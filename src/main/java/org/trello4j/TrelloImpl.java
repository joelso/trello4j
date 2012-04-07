package org.trello4j;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.trello4j.gson.PermissionTypeDeserializer;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Board.PERMISSION_TYPE;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class TrelloImpl implements Trello {
	private static final Logger logger = LoggerFactory.getLogger(TrelloImpl.class);
	private static final Charset UTF_8_CHAR_SET = Charset.forName("UTF-8");
	private static final String GZIP_ENCODING = "gzip";
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"; 

	private final JsonParser parser = new JsonParser();
	
	private String apiKey = null;
	private String secret = null;
	
	private String authQueryString = null;
	
	public TrelloImpl(String apiKey) {
		this(apiKey, null);
	}

	public TrelloImpl(String apiKey, String secret) {
		this.apiKey = apiKey;
		this.secret = secret;
		
		if(this.apiKey == null) {
			throw new TrelloException("API key must be set, get one here: https://trello.com/1/appKey/generate");
		} 
		
		this.authQueryString = createAuthQueryString();
	}

	/* (non-Javadoc)
	 * @see org.trello4j.TrelloI#getBoard(java.lang.String)
	 */
	@Override
	public Board getBoard(String boardId) {
		JsonObject json = unmarshall( doApiGet( buildUrl(TrelloURL.BOARD_URL, boardId) ) );
		return unmarshall(new TypeToken<Board>(){}, json);
	}
	
	/* (non-Javadoc)
	 * @see org.trello4j.TrelloI#getAction(java.lang.String)
	 */
	@Override
	public Action getAction(String actionId) {
		JsonObject json = unmarshall( doApiGet( buildUrl(TrelloURL.ACTION_URL, actionId) ) );
		return unmarshall(new TypeToken<Action>(){}, json);
	}

	/* (non-Javadoc)
	 * @see org.trello4j.TrelloI#getOrganization(java.lang.String)
	 */
	@Override
	public Organization getOrganization(String organizationName) {
		JsonObject json = unmarshall( doApiGet( buildUrl(TrelloURL.ORGANIZATION_URL, organizationName) ) );
		return unmarshall(new TypeToken<Organization>(){}, json);
	}
	
	@Override
	public Member getMember(String username) {
		JsonObject json = unmarshall( doApiGet( buildUrl(TrelloURL.MEMBER_URL, username) ) );
		return unmarshall(new TypeToken<Member>(){}, json);
	}

	
	private InputStream doApiGet(String url) {
		try {
			HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			
			logger.debug("Connecting...");
			conn.connect();
			logger.debug("Connected...");

			return getWrappedInputStream(conn.getInputStream(), GZIP_ENCODING.equalsIgnoreCase(conn.getContentEncoding()));
		} catch (IOException e) {
			throw new TrelloException(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	private <T> T unmarshall(TypeToken<T> typeToken, JsonElement response) {
		Gson gson = new GsonBuilder()
			.setDateFormat(DATE_FORMAT)
			.registerTypeAdapter(PERMISSION_TYPE.class, new PermissionTypeDeserializer())
			.create();

		return (T) gson.fromJson(response, typeToken.getType());
	}
	
	private InputStream getWrappedInputStream(InputStream is, boolean gzip) throws IOException {
		/*
		 * TODO: What about this? 
		 * ----------------
		 * Java clients which use java.util.zip.GZIPInputStream() and wrap it 
		 * with a java.io.BufferedReader() to read streaming API data will 
		 * encounter buffering on low volume streams, since GZIPInputStream's 
		 * available() method is not suitable for streaming purposes. To fix this, 
		 * create a subclass of GZIPInputStream() which overrides the available() method.
		 * 
		 * https://dev.twitter.com/docs/streaming-api/concepts#gzip-compression
		 * 
		 */
		if (gzip) {
			return new BufferedInputStream(new GZIPInputStream(is));
		} else {
			return new BufferedInputStream(is);
		}
	}

	private JsonObject unmarshall(InputStream jsonContent) {
		try {
			JsonElement element = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
			if (element.isJsonObject()) {
				return element.getAsJsonObject();
			} else {
				throw new IllegalStateException("Unknown content found in response." + element);
			}
		} catch (Exception e) {
			throw new TrelloException();
		} finally {
			closeStream(jsonContent);
		}
	}

	private void closeStream(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			new TrelloException();
		}
	}
	
	private String createAuthQueryString() {
		StringBuilder sb = new StringBuilder("?key=").append(apiKey);
		
		if(this.secret != null) {
			sb.append("&").append(this.secret);
		}
		return sb.toString();
	}
	
	private String buildUrl(String boardUrl, String... pathParams) {
		for (int i = 0; i < pathParams.length; i++) {
			boardUrl = boardUrl.replaceAll("\\{" + i + "\\}", pathParams[i]);
		}
		boardUrl += authQueryString;
		logger.debug("Built url {}", boardUrl);
		return boardUrl;
	}

}

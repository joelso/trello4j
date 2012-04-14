package org.trello4j;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;
import org.trello4j.model.Organization;

import com.google.gson.reflect.TypeToken;

public class TrelloImpl implements Trello {
	
	private static final String GZIP_ENCODING = "gzip";
	private static final String PATH_PARAM_ARG_PREFIX = "\\{";
	private static final String PATH_PARAM_ARG_SUFFIX = "\\}";
	
	private String apiKey = null;
	private String token = null;
	
	private String authQueryString = null;
	
	private TrelloObjectFactoryImpl trelloObjFactory = new TrelloObjectFactoryImpl();
	
	public TrelloImpl(String apiKey) {
		this(apiKey, null);
	}

	public TrelloImpl(String apiKey, String token) {
		this.apiKey = apiKey;
		this.token = token;
		
		if(this.apiKey == null) {
			throw new TrelloException("API key must be set, get one here: https://trello.com/1/appKey/generate");
		} 
		
		this.authQueryString = createAuthQueryString();
	}

	@Override
	public Board getBoard(final String boardId) {
		validateObjectId(boardId);
		final String url = buildUrl(TrelloURL.BOARD_URL, boardId);
		return trelloObjFactory.createObject(new TypeToken<Board>(){}, doApiGet(url));
	}
	
	@Override
	public List<Action> getActionsByBoard(final String boardId) {
		validateObjectId(boardId);
		final String url = buildUrl(TrelloURL.BOARD_ACTIONS_URL, boardId);
		return trelloObjFactory.createObject(new TypeToken<List<Action>>(){}, doApiGet(url));
	}
	
	@Override
	public Action getAction(final String actionId) {
		validateObjectId(actionId);
		final String url = buildUrl(TrelloURL.ACTION_URL, actionId);
		return trelloObjFactory.createObject(new TypeToken<Action>(){}, doApiGet(url));
	}

	@Override
	public Organization getOrganization(String organizationName) {
		final String url = buildUrl(TrelloURL.ORGANIZATION_URL, organizationName);
		return trelloObjFactory.createObject(new TypeToken<Organization>(){}, doApiGet(url));
	}
	
	@Override
	public Member getMember(String usernameOrId) {
		final String url = buildUrl(TrelloURL.MEMBER_URL, usernameOrId);
		return trelloObjFactory.createObject(new TypeToken<Member>(){}, doApiGet(url));
	}

    @Override
    public List<Board> getBoardsByMember(String usernameOrId) {
        final String url = buildUrl(TrelloURL.MEMBER_BOARDS_URL, usernameOrId);
        return trelloObjFactory.createObject(new TypeToken<List<Board>>(){}, doApiGet(url));
    }

    @Override
	public List<Board> getBoardsByOrganization(String organizationName) {
		final String url = buildUrl(TrelloURL.ORGANIZATION_BOARDS_URL, organizationName);
		return trelloObjFactory.createObject(new TypeToken<List<Board>>(){}, doApiGet(url));
	}

    @Override
    public List<Action> getActionsByOrganization(String organizationNameOrId) {
        final String url = buildUrl(TrelloURL.ORGANIZATION_ACTIONS_URL, organizationNameOrId);
        return trelloObjFactory.createObject(new TypeToken<List<Action>>(){}, doApiGet(url));    
    }

    @Override
	public Card getCard(final String cardId) {
		validateObjectId(cardId);
		final String url = buildUrl(TrelloURL.CARD_URL, cardId);
		return trelloObjFactory.createObject(new TypeToken<Card>(){}, doApiGet(url));
	}
	
	@Override
	public org.trello4j.model.List getList(final String listId) {
		validateObjectId(listId);
		final String url = buildUrl(TrelloURL.LIST_URL, listId);
		return trelloObjFactory.createObject(new TypeToken<org.trello4j.model.List>(){}, doApiGet(url));
	}
	
	@Override
	public Notification getNotification(String notificationId) {
		validateObjectId(notificationId);
		final String url = buildUrl(TrelloURL.NOTIFICATION_URL, notificationId);
		return trelloObjFactory.createObject(new TypeToken<Notification>(){}, doApiGet(url));
	}
	
	private InputStream doApiGet(String url) {
		try {
			HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.connect();
			
			// Return null if we get an error response
			if(conn.getResponseCode() > 399) {
				return null;
			} else {
				return getWrappedInputStream(conn.getInputStream(), GZIP_ENCODING.equalsIgnoreCase(conn.getContentEncoding()));
			}
		} catch (IOException e) {
			throw new TrelloException(e.getMessage());
		}
	}
	
	private InputStream getWrappedInputStream(InputStream is, boolean gzip) throws IOException {
		/*
		 * TODO: What about this? 
		 * ----------------------
		 * "Java clients which use java.util.zip.GZIPInputStream() and wrap it 
		 * with a java.io.BufferedReader() to read streaming API data will encounter 
		 * buffering on low volume streams, since GZIPInputStream's available() 
		 * method is not suitable for streaming purposes. To fix this, create a 
		 * subclass of GZIPInputStream() which overrides the available() method."
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

	private String createAuthQueryString() {
		StringBuilder sb = new StringBuilder("?key=").append(apiKey);
		
		if(this.token != null) {
			sb.append("&token=").append(this.token);
		}
		return sb.toString();
	}
	
	private void validateObjectId(String id) {
		if(!TrelloUtil.isObjectIdValid(id)) {
			throw new TrelloException("Invalid object id: " + id);
		}
	}
	
	private String buildUrl(String boardUrl, String... pathParams) {
		for (int i = 0; i < pathParams.length; i++) {
			boardUrl = boardUrl.replaceAll(PATH_PARAM_ARG_PREFIX + i + PATH_PARAM_ARG_SUFFIX, pathParams[i]);
		}
		boardUrl += authQueryString;
		return boardUrl;
	}

}

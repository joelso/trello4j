package org.trello4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.trello4j.gson.PermissionTypeDeserializer;
import org.trello4j.model.Board.PERMISSION_TYPE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class TrelloObjectFactoryImpl {
	
	private static final Charset UTF_8_CHAR_SET = Charset.forName("UTF-8");
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"; 

	private final JsonParser parser = new JsonParser();

	public <T> T createObject(TypeToken<T> typeToken, InputStream jsonContent) {
		return jsonContent != null ? unmarshallToObj(typeToken, unmarshallToJson(jsonContent)) : null;
	}
	
//	private <T> T nullOrEmptyList(TypeToken<T> typeToken) {
//	    if (Collection.class.isAssignableFrom(typeToken.getRawType())) {
//	        return List<T> list = Collections.emptyList();
//	    }
//	}
	
	private JsonElement unmarshallToJson(InputStream jsonContent) {
		try {
			JsonElement element = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
			if (element.isJsonObject()) {
				return element.getAsJsonObject();
			} 
			else if(element.isJsonArray()) {
				return element.getAsJsonArray();
			}
			else {
				throw new IllegalStateException("Unknown content found in response." + element);
			}
		} catch (Exception e) {
			throw new TrelloException(e.getMessage());
		} finally {
			closeStream(jsonContent);
		}
	}
	
	@SuppressWarnings("unchecked")
	private <T> T unmarshallToObj(TypeToken<T> typeToken, JsonElement response) {
		Gson gson = new GsonBuilder()
			.setDateFormat(DATE_FORMAT)
			.registerTypeAdapter(PERMISSION_TYPE.class, new PermissionTypeDeserializer())
			.create();

		return (T) gson.fromJson(response, typeToken.getType());
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
	
}

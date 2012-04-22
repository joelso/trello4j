package org.trello4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.trello4j.gson.PermissionTypeDeserializer;
import org.trello4j.gson.TrelloTypeDeserializer;
import org.trello4j.model.Board.PERMISSION_TYPE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.trello4j.model.TrelloType;

public class TrelloObjectFactoryImpl {
	
	private static final Charset UTF_8_CHAR_SET = Charset.forName("UTF-8");
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	private final JsonParser parser = new JsonParser();
    private Gson gson = null;


    @SuppressWarnings("unchecked")
	public <T> T createObject(TypeToken<T> typeToken, InputStream jsonContent) {
        if(jsonContent == null) {
            return isList(typeToken) ? (T) Collections.emptyList() : null;
        }
		return unmarshallToObj(typeToken, unmarshallToJson(jsonContent));
	}
	
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
		return (T) getGson().fromJson(response, typeToken.getType());
	}

    private Gson getGson() {
        if(gson == null) {
            gson = new GsonBuilder()
                 .setDateFormat(DATE_FORMAT)
                 .registerTypeAdapter(PERMISSION_TYPE.class, new PermissionTypeDeserializer())
                 .registerTypeAdapter(TrelloType.class, new TrelloTypeDeserializer())
                 .create();
        }
        return gson;
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

    private boolean isList(TypeToken typeToken) {
        return List.class.isAssignableFrom(typeToken.getRawType());
    }
	
}

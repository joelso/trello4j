package org.trello4j;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.trello4j.gson.PermissionTypeDeserializer;
import org.trello4j.gson.TrelloTypeDeserializer;
import org.trello4j.model.Board.PERMISSION_TYPE;
import org.trello4j.model.TrelloType;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/**
 * The Class TrelloObjectFactoryImpl.
 */
public class TrelloObjectFactoryImpl {

	private static final Charset UTF_8_CHAR_SET = Charset.forName("UTF-8");
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	private final JsonParser parser = new JsonParser();

	private Gson gson = null;

	/**
	 * Creates the object.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param typeToken
	 *            the type token
	 * @param jsonContent
	 *            the json content
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public <T> T createObject(TypeToken<T> typeToken, InputStream jsonContent) {
		if (jsonContent == null) {
			return isList(typeToken) ? (T) Collections.emptyList() : null;
		}
		return unmarshallToObj(typeToken, unmarshallToJson(jsonContent));
	}

	/**
	 * Unmarshall to json.
	 * 
	 * @param jsonContent
	 *            the json content
	 * @return the json element
	 */
	private JsonElement unmarshallToJson(InputStream jsonContent) {
		try {
			JsonElement element = parser.parse(new InputStreamReader(
					jsonContent,
					UTF_8_CHAR_SET));
			if (element.isJsonObject()) {
				return element.getAsJsonObject();
			} else if (element.isJsonArray()) {
				return element.getAsJsonArray();
			} else {
				throw new IllegalStateException(
						"Unknown content found in response." + element);
			}
		} catch (Exception e) {
			throw new TrelloException(e.getMessage());
		} finally {
			closeStream(jsonContent);
		}
	}

	/**
	 * Unmarshall to obj.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param typeToken
	 *            the type token
	 * @param response
	 *            the response
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	private <T> T unmarshallToObj(TypeToken<T> typeToken, JsonElement response) {
		return (T) getGson().fromJson(response, typeToken.getType());
	}

	/**
	 * Gets the gson.
	 * 
	 * @return the gson
	 */
	private Gson getGson() {
		if (gson == null) {
			gson = new GsonBuilder()
					.setDateFormat(DATE_FORMAT)
					.registerTypeAdapter(
							PERMISSION_TYPE.class,
							new PermissionTypeDeserializer())
					.registerTypeAdapter(
							TrelloType.class,
							new TrelloTypeDeserializer())
					.create();
		}
		return gson;
	}

	/**
	 * Close stream.
	 * 
	 * @param is
	 *            the is
	 */
	private void closeStream(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			new TrelloException();
		}
	}

	/**
	 * Checks if is list.
	 * 
	 * @param typeToken
	 *            the type token
	 * @return true, if is list
	 */
	private boolean isList(TypeToken typeToken) {
		return List.class.isAssignableFrom(typeToken.getRawType());
	}

}

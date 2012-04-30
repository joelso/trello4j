package org.trello4j.gson;

import java.lang.reflect.Type;

import org.trello4j.model.TrelloType;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Translate type string to TrelloType enum.
 * 
 * @author joel
 * 
 */
public class TrelloTypeDeserializer implements JsonDeserializer<TrelloType> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	public TrelloType deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		final String jsonStr = json.getAsString();
		return jsonStr == null ? null : TrelloType.fromString(jsonStr);
	}

}

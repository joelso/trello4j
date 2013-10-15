package org.trello4j.model;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import org.trello4j.model.TrelloType.*;

import java.io.*;

/**
 * Created with IntelliJ IDEA. User: Joel Soderstrom
 * (joel[at]frostdigital[dot]se) Date: 2012-04-22 Time: 4:20 PM
 */
@JsonDeserialize(using = TrelloTypeJsonDeserializer.class)
public enum TrelloType {

	ORGANIZATION,
	ACTION,
	BOARD,
	CHECKLIST,
	LIST,
	MEMBER,
	NOTIFICATION,
	UNKNOWN;

	private TrelloType() {
	}

	public static TrelloType fromString(String str) {
		TrelloType type = TrelloType.UNKNOWN;
		try {
			type = TrelloType.valueOf(str.toUpperCase());
		} catch (Exception e) {
			// do nothing
		}
		return type;
	}

	public static class TrelloTypeJsonDeserializer extends JsonDeserializer<TrelloType> {
		public TrelloType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			String str = jp.getValueAsString();
			return fromString(str);
		}
	}
}
package org.trello4j.gson;

import java.lang.reflect.Type;

import org.trello4j.model.Board.PERMISSION_TYPE;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * We need extra handling of permission types "public, organization, members"
 * since "public" is a reserved word in java.
 * 
 * @author joel
 * 
 */
public class PermissionTypeDeserializer implements
		JsonDeserializer<PERMISSION_TYPE> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
	 * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	public PERMISSION_TYPE deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {

		final String jsonStr = json.getAsString().toUpperCase();

		PERMISSION_TYPE[] permissionTypes = PERMISSION_TYPE.values();
		for (PERMISSION_TYPE permissionType : permissionTypes) {
			if (permissionType.name().equals(jsonStr))
				return permissionType;
		}

		return null;
	}

}

package org.trello4j.gson;

import java.lang.reflect.Type;

import org.trello4j.model.Board.PERMISSION_TYPE;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * We need extra handling of permission types "public, organization, members"
 * since "public" is a reserver word in java. 
 * 
 * Simple solution is to use upper case enum, but then we also need to make
 * 
 * @author joel
 *
 */
public class PermissionTypeDeserializer implements
		JsonDeserializer<PERMISSION_TYPE> {

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

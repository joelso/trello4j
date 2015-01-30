package org.trello4j.gson;

import java.io.IOException;

import org.trello4j.model.Board.PERMISSION_TYPE;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * We need extra handling of permission types "public, organization, members"
 * since "public" is a reserved word in java.
 */

public class CopyOfPermissionTypeDeserializer extends JsonDeserializer<PERMISSION_TYPE> {

	@Override
	public PERMISSION_TYPE deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String jsonStr = jp.getText().toUpperCase();

		PERMISSION_TYPE[] permissionTypes = PERMISSION_TYPE.values();
		for (PERMISSION_TYPE permissionType : permissionTypes) {
			if (permissionType.name().equals(jsonStr))
				return permissionType;
		}
		return null;
	}
}

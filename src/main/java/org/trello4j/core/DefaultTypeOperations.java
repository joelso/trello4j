package org.trello4j.core;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURI;
import org.trello4j.model.Type;

import com.google.gson.reflect.TypeToken;

public class DefaultTypeOperations extends AbstractOperations implements TypeOperations {

	DefaultTypeOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
	}

	@Override
	public Type getType(String idOrName) {
		final String url = TrelloURI.create(apiKey, TrelloURI.TYPE_URL, idOrName).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Type>() {
		}, doGet(url));
	}
}

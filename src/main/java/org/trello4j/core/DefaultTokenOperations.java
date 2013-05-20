package org.trello4j.core;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURI;
import org.trello4j.model.Member;
import org.trello4j.model.Token;

import com.google.gson.reflect.TypeToken;

public class DefaultTokenOperations extends AbstractOperations implements TokenOperations {

	DefaultTokenOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
	}

	@Override
	public Token getToken(String tokenId, final String... filter) {
		// validateObjectId(tokenId);

		final String url = TrelloURI.create(apiKey, TrelloURI.TOKENS_URL, tokenId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Token>() {
		}, doGet(url));
	}

	@Override
	public Member getMemberByToken(String tokenId, final String... filter) {
		// validateObjectId(tokenId);

		final String url = TrelloURI.create(apiKey, TrelloURI.TOKENS_MEMBER_URL, tokenId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doGet(url));
	}

}

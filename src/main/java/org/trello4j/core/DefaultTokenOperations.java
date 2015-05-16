package org.trello4j.core;

import org.trello4j.TrelloURI;
import org.trello4j.model.Member;
import org.trello4j.model.Token;

public class DefaultTokenOperations extends AbstractOperations implements TokenOperations {

	private final String tokenId;

	DefaultTokenOperations(String tokenId, TrelloAccessor trelloAccessor) {
		super(trelloAccessor);
		this.tokenId = tokenId;
	}

	@Override
	public Token get(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.TOKENS_URL, tokenId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Token.class);
	}

	@Override
	public Member getMember(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.TOKENS_MEMBER_URL, tokenId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Member.class);
	}

}

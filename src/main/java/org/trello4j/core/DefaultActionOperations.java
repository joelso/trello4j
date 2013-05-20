package org.trello4j.core;

import org.trello4j.TrelloURI;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.List;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

public class DefaultActionOperations extends AbstractOperations implements ActionOperations {

	private String actionId;

	public DefaultActionOperations(String actionId, TrelloAccessor trelloAccessor) {
		super(trelloAccessor);
		validateObjectId(actionId);
		this.actionId = actionId;
	}

	@Override
	public Action get(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ACTION_URL, actionId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Action.class);
	}

	@Override
	public Board getBoard(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ACTION_BOARD_URL, actionId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Board.class);
	}

	@Override
	public Card getCard(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ACTION_CARD_URL, actionId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Card.class);
	}

	@Override
	public Member getMember(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ACTION_MEMBER_URL, actionId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Member.class);
	}

	@Override
	public List getList(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ACTION_LIST_URL, actionId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), List.class);
	}

	@Override
	public Member getMemberCreator(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ACTION_MEMBERCREATOR_URL, actionId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Member.class);
	}

	@Override
	public Organization getOrganization(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ACTION_ORGANIZATION_URL, actionId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Organization.class);
	}
}

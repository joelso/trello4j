package org.trello4j.core;

import org.trello4j.TrelloURL;
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
		return getTrelloAccessor().doGet(Action.class, TrelloURL.ACTION_URL, actionId, filters);
	}

	@Override
	public Board getBoard(final String... filters) {
		return getTrelloAccessor().doGet(Board.class, TrelloURL.ACTION_BOARD_URL, actionId, filters);
	}

	@Override
	public Card getCard(final String... filters) {
		return getTrelloAccessor().doGet(Card.class, TrelloURL.ACTION_CARD_URL, actionId, filters);
	}

	@Override
	public Member getMember(final String... filters) {
		return getTrelloAccessor().doGet(Member.class, TrelloURL.ACTION_MEMBER_URL, actionId, filters);
	}

	@Override
	public List getList(final String... filters) {
		return getTrelloAccessor().doGet(List.class, TrelloURL.ACTION_LIST_URL, actionId, filters);
	}

	@Override
	public Member getMemberCreator(final String... filters) {
		return getTrelloAccessor().doGet(Member.class, TrelloURL.ACTION_MEMBERCREATOR_URL, actionId, filters);
	}

	@Override
	public Organization getOrganization(final String... filters) {
		return getTrelloAccessor().doGet(Organization.class, TrelloURL.ACTION_ORGANIZATION_URL, actionId, filters);
	}
}

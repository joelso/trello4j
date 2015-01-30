package org.trello4j.core;

import org.trello4j.TrelloURI;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.List;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;

public class DefaultNotificationOperations extends AbstractOperations implements NotificationOperations {

	private final String notificationId;

	DefaultNotificationOperations(String notificationId, TrelloAccessor trelloAccessor) {
		super(trelloAccessor);
		validateObjectId(notificationId);
		this.notificationId = notificationId;
	}

	@Override
	public Notification get(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.NOTIFICATION_URL, notificationId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Notification.class);
	}

	@Override
	public Board getBoard(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.NOTIFICATION_BOARDS_URL, notificationId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Board.class);
	}

	@Override
	public Card getCard(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.NOTIFICATION_CARDS_URL, notificationId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Card.class);
	}

	@Override
	public List getList(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.NOTIFICATION_LIST_URL, notificationId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), List.class);
	}

	@Override
	public Member getMember(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.NOTIFICATION_MEMBERS_URL, notificationId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Member.class);
	}

	@Override
	public Member getMemberCreator(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.NOTIFICATION_MEMBER_CREATOR_URL, notificationId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Member.class);
	}

	@Override
	public Member getOrganizationCreator(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.NOTIFICATION_ORGANIZATION_URL, notificationId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Member.class);
	}
}
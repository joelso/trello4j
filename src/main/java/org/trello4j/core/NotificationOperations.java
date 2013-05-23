package org.trello4j.core;

import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.List;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;

public interface NotificationOperations {

	Notification get(String... filters);

	Board getBoard(String... filters);

	Card getCard(String... filters);

	List getList(String... filters);

	Member getMember(String... filters);

	Member getMemberCreator(String... filters);

	Member getOrganizationCreator(String... filter);
}
package org.trello4j.core;

import java.util.List;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;
import org.trello4j.model.Organization;

public interface MemberOperations {

	Member get(String... filters);

	List<Board> getBoards(String... filters);

	List<Action> getActions();

	List<Card> getCards(String... filters);

	List<Notification> getNotifications(String... filters);

	List<Organization> getOrganizations(String... filters);

	List<Organization> getInvitedOrganizations(String... filters);

}
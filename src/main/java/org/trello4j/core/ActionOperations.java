package org.trello4j.core;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.List;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

public interface ActionOperations {

	Action get(String... filter);

	Board getBoard(String... filter);

	Card getCard(String... filter);

	Member getMember(String... filter);

	Member getMemberCreator(String... filter);

	Organization getOrganization(String... filter);

	List getList(String... filter);

}
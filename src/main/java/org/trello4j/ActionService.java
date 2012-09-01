package org.trello4j;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.List;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

/**
 * The Interface ActionService.
 * 
 * @author joel
 */
public interface ActionService {

	Action getAction(String actionId, String... filter);

	Board getBoardByAction(String actionId, String... filter);

	Card getCardByAction(String actionId, String... filter);

	Member getMemberByAction(String actionId, String... filter);

	Member getMemberCreatorByAction(String actionId, String... filter);

	Organization getOrganizationByAction(String actionId, String... filter);

	List getListByAction(String actionId, String... filter);

}
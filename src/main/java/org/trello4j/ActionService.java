package org.trello4j;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Board.Prefs;
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
	
	/**
	 * Get action of current ID.
	 *
	 * @param actionId the action id
	 * @return the action
	 */
	Action getAction(String actionId);
	
	/**
	 * Gets the board by action.
	 *
	 * @param actionId the action id
	 * @return the board by action
	 */
	Board getBoardByAction(String actionId);
	
	/**
	 * Gets the card by action.
	 *
	 * @param actionId the action id
	 * @return the card by action
	 */
	Card getCardByAction(String actionId);
	
	/**
	 * Gets the member by action.
	 *
	 * @param actionId the action id
	 * @return the member by action
	 */
	Member getMemberByAction(String actionId);
	
	/**
	 * Gets the member creator by action.
	 *
	 * @param actionId the action id
	 * @return the member creator by action
	 */
	Member getMemberCreatorByAction(String actionId);

	/**
	 * Gets the organization by action.
	 *
	 * @param actionId the action id
	 * @return the organization by action
	 */
	Organization getOrganizationByAction(String actionId);

	/**
	 * Gets the list by action.
	 *
	 * @param actionId the action id
	 * @return the list by action
	 */
	List getListByAction(String actionId);

	/**
	 * Gets the prefs by board.
	 *
	 * @param boardId the board id
	 * @return the prefs by board
	 */
	Prefs getPrefsByBoard(String boardId);
}
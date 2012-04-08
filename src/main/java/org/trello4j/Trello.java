package org.trello4j;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Member;

public interface Trello extends OrganizationService {
	
	/**
	 * Get board of given ID
	 * 
	 * @param boardId
	 * @return
	 */
	Board getBoard(String boardId);

	/**
	 * Get action of current ID
	 * @param actionId
	 * @return
	 */
	Action getAction(String actionId);

	/**
	 * Get member of given username.
	 * @param username
	 * @return
	 */
	Member getMember(String username);

}
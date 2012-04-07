package org.trello4j;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

public interface Trello {
	
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
	 * Get organization of given ID
	 * @param organizationName
	 * @return
	 */
	Organization getOrganization(String organizationName);
	
	/**
	 * Get member of given username.
	 * @param username
	 * @return
	 */
	Member getMember(String username);

}
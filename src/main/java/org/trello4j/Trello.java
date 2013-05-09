package org.trello4j;

import org.trello4j.core.ActionOperations;
import org.trello4j.core.BoardOperations;
import org.trello4j.core.CardOperations;
import org.trello4j.core.ChecklistOperations;
import org.trello4j.core.ListOperations;
import org.trello4j.core.MemberOperations;
import org.trello4j.core.NotificationOperations;
import org.trello4j.core.OrganizationOperations;
import org.trello4j.model.Type;

/**
 * The Interface Trello.
 */
public interface Trello extends OrganizationOperations, NotificationOperations,
		BoardOperations, CardOperations, ActionOperations, ListOperations, MemberOperations,
		ChecklistOperations, TokenService {

	/**
	 * Gets the type.
	 * 
	 * @param idOrName
	 *            the id or name
	 * @return the type
	 */
	Type getType(String idOrName);

}
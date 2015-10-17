package org.trello4j;

import org.trello4j.model.Type;

/**
 * The Interface Trello.
 */
public interface Trello extends OrganizationService, NotificationService,
		BoardService, CardService, ActionService, ListService, MemberService,
		ChecklistService, TokenService, WebhookService {

	/**
	 * Gets the type.
	 * 
	 * @param idOrName
	 *            the id or name
	 * @return the type
	 */
	Type getType(String idOrName);

}
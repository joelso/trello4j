package org.trello4j;

import java.util.List;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;
import org.trello4j.model.Organization;

/**
 * The Interface MemberService.
 * 
 * @author joel
 */
public interface MemberService {

	/**
	 * Get member of given username.
	 * 
	 * @param usernameOrId
	 *            the username or id
	 * @return the member
	 */
	Member getMember(String usernameOrId, String... filter);

	/**
	 * Get list of boards that member is member of.
	 * 
	 * @param usernameOrId
	 *            the username or id
	 * @return the boards by member
	 */
	List<Board> getBoardsByMember(String usernameOrId, String... filter);

	/**
	 * Gets the actions by member.
	 * 
	 * @param usernameOrId
	 *            the username or id
	 * @return the actions by member
	 */
	List<Action> getActionsByMember(String usernameOrId);

	/**
	 * Gets the cards by member.
	 * 
	 * @param usernameOrId
	 *            the username or id
	 * @return the cards by member
	 */
	List<Card> getCardsByMember(String usernameOrId, String... filter);

	/**
	 * Gets the notifications by member.
	 * 
	 * @param usernameOrId
	 *            the username or id
	 * @return the notifications by member
	 */
	List<Notification> getNotificationsByMember(String usernameOrId,
			String... filter);

	/**
	 * Gets the organizations by member.
	 * 
	 * @param usernameOrId
	 *            the username or id
	 * @return the organizations by member
	 */
	List<Organization> getOrganizationsByMember(String usernameOrId,
			String... filter);

	/**
	 * Gets the organizations invited by member.
	 * 
	 * @param usernameOrId
	 *            the username or id
	 * @return the organizations invited by member
	 */
	List<Organization> getOrganizationsInvitedByMember(String usernameOrId,
			String... filter);

}
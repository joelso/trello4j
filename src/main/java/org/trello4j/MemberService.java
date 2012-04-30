package org.trello4j;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;
import org.trello4j.model.Organization;

import java.util.List;



/**
 * The Interface MemberService.
 *
 * @author joel
 */
public interface MemberService {
	
	/**
	 * Get member of given username.
	 *
	 * @param usernameOrId the username or id
	 * @return the member
	 */
	Member getMember(String usernameOrId);

    /**
     * Get list of boards that member is member of.
     *
     * @param usernameOrId the username or id
     * @return the boards by member
     */
    List<Board> getBoardsByMember(String usernameOrId);
    
    
    /**
     * Gets the actions by member.
     *
     * @param usernameOrId the username or id
     * @return the actions by member
     */
    List<Action> getActionsByMember(String usernameOrId);
    
    /**
     * Gets the cards by member.
     *
     * @param usernameOrId the username or id
     * @return the cards by member
     */
    List<Card> getCardsByMember(String usernameOrId);
    
    /**
     * Gets the notifications by member.
     *
     * @param usernameOrId the username or id
     * @return the notifications by member
     */
    List<Notification> getNotificationsByMember(String usernameOrId);
    
    /**
     * Gets the organizations by member.
     *
     * @param usernameOrId the username or id
     * @return the organizations by member
     */
    List<Organization> getOrganizationsByMember(String usernameOrId);
    
    /**
     * Gets the organizations invited by member.
     *
     * @param usernameOrId the username or id
     * @return the organizations invited by member
     */
    List<Organization> getOrganizationsInvitedByMember(String usernameOrId);

}
package org.trello4j;

import org.trello4j.model.Board;
import org.trello4j.model.Member;

import java.util.List;


/**
 * 
 * @author joel
 * 
 */
public interface MemberService {
	
	/**
	 * Get member of given username.
	 * @param usernameOrId
	 * @return
	 */
	Member getMember(String usernameOrId);

    /**
     * Get list of boards that member is member of.
     * @param usernameOrId
     * @return
     */
    List<Board> getBoardsByMember(String usernameOrId);

}
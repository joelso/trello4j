package org.trello4j;

import org.trello4j.model.Member;


/**
 * 
 * @author joel
 * 
 */
public interface MemberService {
	
	/**
	/**
	 * Get member of given username.
	 * @param username
	 * @return
	 */
	Member getMember(String username);

}
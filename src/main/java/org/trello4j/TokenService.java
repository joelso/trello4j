package org.trello4j;

import org.trello4j.model.Member;
import org.trello4j.model.Token;

/**
 * The Interface TokenService.
 */
public interface TokenService {

	/**
	 * Gets the token.
	 * 
	 * @param tokenId
	 *            the token id
	 * @return the token
	 */
	Token getToken(String tokenId, String... filter);

	/**
	 * Gets the member by token.
	 * 
	 * @param tokenId
	 *            the token id
	 * @return the member by token
	 */
	Member getMemberByToken(String tokenId, String... filter);
}

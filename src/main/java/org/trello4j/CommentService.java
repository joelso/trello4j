package org.trello4j;

import org.trello4j.model.Comment;

/**
 * The Interface CardService.
 * 
 * @author 
 */
public interface CommentService {

	/**
	 * Add a new {@link org.trello4j.model.Comment} with the optional keyValue pairs.
	 * @param cardId Id of the {@link org.trello4j.model.Card}
	 *               the comment should be added to.
	 * @param text body of the new comment.
	 */
    Comment createComment(String cardId, String text);
}

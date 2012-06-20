package org.trello4j;

import java.util.List;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Board.Prefs;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

/**
 * 
 * @author joel
 */
public interface BoardService {

	/**
	 * Get board of given ID.
	 * 
	 * @param boardId
	 *            the board id
	 * @return the board
	 */
	Board getBoard(String boardId);

	/**
	 * Get list of actions that belongs to given board.
	 * 
	 * @param boardId
	 *            the board id
	 * @param filter
	 *            the filter
	 * @return list of actions
	 */
	List<Action> getActionsByBoard(String boardId, String... filter);

	/**
	 * Gets the organization by board.
	 * 
	 * @param boardId
	 *            the board id
	 * @return the organization by board
	 */
	Organization getOrganizationByBoard(String boardId, String... filter);

	/**
	 * Gets the members invited by board.
	 * 
	 * @param boardId
	 *            the board id
	 * @return the members invited by board
	 */
	List<Member> getMembersInvitedByBoard(String boardId, String... filter);

	/**
	 * Gets the members by board.
	 * 
	 * @param boardId
	 *            the board id
	 * @return the members by board
	 */
	List<Member> getMembersByBoard(String boardId, String... filter);

	/**
	 * Gets the list by board.
	 * 
	 * @param boardId
	 *            the board id
	 * @return the list by board
	 */
	List<org.trello4j.model.List> getListByBoard(String boardId,
			String... filter);

	/**
	 * Gets the checklist by board.
	 * 
	 * @param boardId
	 *            the board id
	 * @return the checklist by board
	 */
	List<Checklist> getChecklistByBoard(String boardId);

	/**
	 * Gets the cards by board.
	 * 
	 * @param boardId
	 *            the board id
	 * @return the cards by board
	 */
	List<Card> getCardsByBoard(String boardId, String... filter);

	/**
	 * Gets the prefs by board.
	 * 
	 * @param boardId
	 *            the board id
	 * @return the prefs by board
	 */
	Prefs getPrefsByBoard(String boardId);

}
package org.trello4j;

import java.util.List;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Card.Attachment;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;
import org.trello4j.model.Member;



/**
 * The Interface CardService.
 *
 * @author joel
 */
public interface CardService {
	
	/**
	 * Gets the card.
	 *
	 * @param cardId the card id
	 * @return the card
	 */
	Card getCard(String cardId);

	/**
	 * Gets the actions by card.
	 *
	 * @param cardId the card id
	 * @return the actions by card
	 */
	List<Action> getActionsByCard(String cardId);

	/**
	 * Gets the attachements by card.
	 *
	 * @param cardId the card id
	 * @return the attachements by card
	 */
	List<Attachment> getAttachementsByCard(String cardId);

	/**
	 * Gets the board by card.
	 *
	 * @param cardId the card id
	 * @return the board by card
	 */
	Board getBoardByCard(String cardId);

	/**
	 * Gets the check item states by card.
	 *
	 * @param cardId the card id
	 * @return the check item states by card
	 */
	List<CheckItem> getCheckItemStatesByCard(String cardId);

	/**
	 * Gets the checklist by card.
	 *
	 * @param cardId the card id
	 * @return the checklist by card
	 */
	List<Checklist> getChecklistByCard(String cardId);

	/**
	 * Gets the list by card.
	 *
	 * @param cardId the card id
	 * @return the list by card
	 */
	org.trello4j.model.List getListByCard(String cardId);

	/**
	 * Gets the members by card.
	 *
	 * @param cardId the card id
	 * @return the members by card
	 */
	List<Member> getMembersByCard(String cardId);
	
}
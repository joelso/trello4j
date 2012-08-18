package org.trello4j;

import java.util.List;
import java.util.Map;

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
 * @author 
 */
public interface CardService {

	/**
	 * Gets the card.
	 * 
	 * @param cardId
	 *            the card id
	 * @return the card
	 */
	Card getCard(String cardId);

	/**
	 * Gets the actions by card.
	 * 
	 * @param cardId
	 *            the card id
	 * @return the actions by card
	 */
	List<Action> getActionsByCard(String cardId);

	/**
	 * Gets the attachments by card.
	 * 
	 * @param cardId
	 *            the card id
	 * @return the attachements by card
	 */
	List<Attachment> getAttachmentsByCard(String cardId);

	/**                                           +å
	 * Gets the board by card.
	 * 
	 * @param cardId
	 *            the card id
	 * @return the board by card
	 */
	Board getBoardByCard(String cardId, String... filter);

	/**
	 * Gets the check item states by card.
	 * 
	 * @param cardId
	 *            the card id
	 * @return the check item states by card
	 */
	List<CheckItem> getCheckItemStatesByCard(String cardId);

	/**
	 * Gets the checklist by card.
	 * 
	 * @param cardId
	 *            the card id
	 * @return the checklist by card
	 */
	List<Checklist> getChecklistByCard(String cardId);

	/**
	 * Gets the list by card.
	 * 
	 * @param cardId
	 *            the card id
	 * @return the list by card
	 */
	org.trello4j.model.List getListByCard(String cardId, String... filter);

	/**
	 * Gets the members by card.
	 * 
	 * @param cardId
	 *            the card id
	 * @return the members by card
	 */
	List<Member> getMembersByCard(String cardId);

	/**
	 * Add a new {@link Card} with the optional keyValue pairs.
	 * @param idList Id of the {@link org.trello4j.model.List}
	 *               the card should be added to.
	 * @param name Name of the new card.
	 * @param keyValeMap Map of the optional key-value-pairs.
	 */
	Card addNewCard(String idList, String name,
					Map<String, String> keyValeMap);
}

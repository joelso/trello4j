package org.trello4j;

import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;

/**
 * The Interface ChecklistService.
 * 
 * @author joel
 */
public interface ChecklistService {

	/**
	 * Get checklist by given id.
	 * 
	 * @param checklistId
	 *            the checklist id
	 * @return the checklist
	 */
	Checklist getChecklist(String checklistId, String... filter);

	/**
	 * Gets the board by checklist.
	 * 
	 * @param checklistId
	 *            the checklist id
	 * @return the board by checklist
	 */
	Board getBoardByChecklist(String checklistId, String... filter);

	/**
	 * Gets the card by checklist.
	 * 
	 * @param checklistId
	 *            the checklist id
	 * @return the card by checklist
	 */
	java.util.List<Card> getCardByChecklist(String checklistId,
			String... filter);

	/**
	 * Gets the check items by checklist.
	 * 
	 * @param checklistId
	 *            the checklist id
	 * @return the check items by checklist
	 */
	java.util.List<CheckItem> getCheckItemsByChecklist(String checklistId);
}
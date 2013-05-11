package org.trello4j.core;

import java.io.File;
import java.net.URL;
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
public interface CardOperations {

	Card getCard(String cardId);

	List<Action> getActionsByCard(String cardId);

	List<Attachment> getAttachmentsByCard(String cardId);

	Board getBoardByCard(String cardId, String... filter);

	List<CheckItem> getCheckItemStatesByCard(String cardId);

	List<Checklist> getChecklistByCard(String cardId);

	org.trello4j.model.List getListByCard(String cardId, String... filter);

	List<Member> getMembersByCard(String cardId);

	/**
	 * Add a new {@link Card} with the optional keyValue pairs.
	 * 
	 * @param idList
	 *            Id of the {@link org.trello4j.model.List} the card should be
	 *            added to.
	 * @param name
	 *            Name of the new card.
	 * @param keyValeMap
	 *            Map of the optional key-value-pairs.
	 * @param filter
	 */
	Card createCard(String idList, String name, Map<String, Object> keyValueMap, String... filter);

	Action commentOnCard(String idCard, String text, String... filter);

	List<Attachment> attachToCard(String idCard, File file, URL attachmentUrl, String name, String mimeType, String... filter);

	/**
	 * Required permissions: write
	 * 
	 * @param idCard
	 *            The id of the card to add the checklist to.
	 * @param idChecklist
	 *            The id of the checklist to add to the card, or null to create
	 *            a new one.
	 * @param checklistName
	 *            Name of the checklist.
	 * @param idChecklistSource
	 *            The id of the source checklist to copy into a new checklist.
	 * @return The created {@link Checklist}.
	 */
	Checklist addChecklist(String idCard, String idChecklist, String checklistName, String idChecklistSource, String... filter);

	/**
	 * Required permissions: write Arguments:
	 * <ul>
	 * <li>value (required)</li>
	 * <ul>
	 * Valid Values: One of:
	 * <li>green</li>
	 * <li>yellow</li>
	 * <li>orange</li>
	 * <li>red</li>
	 * <li>purple</li>
	 * <li>blue</li>
	 * </ul>
	 * </ul>
	 */
	List<Card.Label> addLabel(String idCard, String label, String... filter);

	List<Member> addMember(String idCard, String memberId, String... filter);

	boolean voteOnCard(String idCard, String memberId, String... filter);

	List<Member> getMemberVotesOnCard(String idCard, String... filter);

	boolean deleteCard(String idCard, String... filter);

	boolean deleteChecklistFromCard(String idCard, String idList, String... filter);

	boolean deleteLabelFromCard(String idCard, String color, String... filter);

	boolean deleteMemberFromCard(String idCard, String idMember, String... filter);

	boolean deleteVoteFromCard(String idCard, String memberId, String... filter);
}

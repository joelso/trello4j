package org.trello4j.core;

import java.io.File;
import java.net.URL;
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
 * @author
 */
public interface CardOperations {

	Card get();

	List<Action> getActions();

	List<Attachment> getAttachments();

	Board getBoard(String... filter);

	List<CheckItem> getCheckItemStates();

	List<Checklist> getChecklist();

	org.trello4j.model.List getList(String... filter);

	List<Member> getMembers();

	Action comment(String text, String... filter);

	List<Attachment> attach(File file, URL attachmentUrl, String name, String mimeType, String... filter);

	Checklist addChecklist(String idChecklist, String checklistName, String idChecklistSource, String... filter);

	List<Card.Label> addLabel(String label, String... filter);

	List<Member> addMember(String memberId, String... filter);

	boolean vote(String memberId, String... filter);

	List<Member> getMemberVotes(String... filter);

	/**
	 * Archives the card.
	 * @param value true to archive, false to remove from archive.
	 * @return true if action was successful.
	 */
	boolean setClosed(boolean value);

	boolean delete(String... filter);

	boolean deleteChecklist(String idList, String... filter);

	boolean deleteLabel(String color, String... filter);

	boolean deleteMember(String idMember, String... filter);

	boolean deleteVote(String memberId, String... filter);
}

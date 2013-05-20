package org.trello4j.core;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.trello4j.TrelloURL;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Card.Attachment;
import org.trello4j.model.Card.Label;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;
import org.trello4j.model.Member;

public class DefaultCardOperations extends AbstractOperations implements CardOperations {

	private final String cardId;

	public DefaultCardOperations(String cardId, TrelloAccessor trelloAccessor) {
		super(trelloAccessor);
		validateObjectId(cardId);
		this.cardId = cardId;
	}

	@Override
	public Card get() {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_URL, cardId);
		return getTrelloAccessor().doGet(uri.build(), Card.class);
	}

	@Override
	public List<Action> getActions() {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_ACTION_URL, cardId);
		ParameterizedTypeReference<List<Action>> typeReference = new ParameterizedTypeReference<List<Action>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Attachment> getAttachments() {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_ATTACHEMENT_URL, cardId);
		ParameterizedTypeReference<List<Attachment>> typeReference = new ParameterizedTypeReference<List<Attachment>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public Board getBoard(final String... filters) {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_BOARD_URL, cardId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Board.class);
	}

	@Override
	public List<CheckItem> getCheckItemStates() {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_CHECK_ITEM_STATES_URL, cardId);
		ParameterizedTypeReference<List<CheckItem>> typeReference = new ParameterizedTypeReference<List<CheckItem>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Checklist> getChecklist() {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_CHECKLISTS_URL, cardId);
		ParameterizedTypeReference<List<Checklist>> typeReference = new ParameterizedTypeReference<List<Checklist>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public org.trello4j.model.List getList(final String... filters) {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_LIST_URL, cardId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), org.trello4j.model.List.class);
	}

	@Override
	public List<Member> getMembers() {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_MEMBERS_URL, cardId);
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public Action comment(String text, String... filters) {
		Map<String, String> keyValueMap = Collections.singletonMap("text", text);
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_POST_COMMENTS, cardId).filter(filters);
		return getTrelloAccessor().doPut(uri.build(), keyValueMap, Action.class);
	}

	@Override
	public List<Attachment> attach(File file, URL attachmentUrl, String name, String mimeType, String... filters) {
		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		if (file != null)
			keyValueMap.put("file", new FileSystemResource(file));
		if (attachmentUrl != null)
			keyValueMap.put("url", attachmentUrl.toString());
		if (name != null)
			keyValueMap.put("name", name);
		if (mimeType != null)
			keyValueMap.put("mimeType", mimeType);

		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_POST_ATTACHMENTS, cardId).filter(filters);
		ParameterizedTypeReference<List<Attachment>> typeReference = new ParameterizedTypeReference<List<Attachment>>() {
		};
		return getTrelloAccessor().doPost(uri.build(), keyValueMap, typeReference);
	}

	@Override
	public Checklist addChecklist(String checklistId, String checklistName, String checklistSource, String... filters) {
		if (checklistId != null) {
			validateObjectId(checklistId);
		}

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("name", checklistName == null ? "Checklist" : checklistName);
		if (checklistId != null) {
			keyValueMap.put("value", checklistId);
		}
		if (checklistSource != null) {
			keyValueMap.put("idChecklistSource", checklistSource);
		}

		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_POST_CHECKLISTS, cardId).filter(filters);
		return getTrelloAccessor().doPost(uri.build(), keyValueMap, Checklist.class);
	}

	@Override
	public List<Label> addLabel(String label, String... filters) {
		Map<String, String> keyValueMap = Collections.singletonMap("value", label);
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_POST_LABELS, cardId).filter(filters);
		ParameterizedTypeReference<List<Label>> typeReference = new ParameterizedTypeReference<List<Label>>() {
		};
		return getTrelloAccessor().doPost(uri.build(), keyValueMap, typeReference);
	}

	@Override
	public List<Member> addMember(String memberId, String... filters) {
		Map<String, String> keyValueMap = Collections.singletonMap("value", memberId);
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_POST_ADD_MEMBER, cardId).filter(filters);
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doPost(uri.build(), keyValueMap, typeReference);
	}

	@Override
	public boolean vote(String memberId, String... filters) {
		Map<String, String> keyValueMap = Collections.singletonMap("value", memberId);
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_POST_VOTE_MEMBER, cardId).filter(filters);
		return getTrelloAccessor().doPost(uri.build(), keyValueMap);
	}

	@Override
	public List<Member> getMemberVotes(String... filters) {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_GET_VOTES, cardId).filter(filters);
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public boolean delete(String... filters) {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_DELETE_CARD, cardId).filter(filters);
		return getTrelloAccessor().doDelete(uri.build());
	}

	@Override
	public boolean deleteChecklist(String listId, String... filters) {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_DELETE_CHECKLIST, cardId, listId).filter(filters);
		return getTrelloAccessor().doDelete(uri.build());
	}

	@Override
	public boolean deleteLabel(String color, String... filters) {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_DELETE_LABEL, cardId, color).filter(filters);
		return getTrelloAccessor().doDelete(uri.build());
	}

	@Override
	public boolean deleteMember(String memberId, String... filters) {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_DELETE_MEMBER, cardId, memberId).filter(filters);
		return getTrelloAccessor().doDelete(uri.build());
	}

	@Override
	public boolean deleteVote(String memberId, String... filters) {
		TrelloURL uri = getTrelloAccessor().createTrelloUri(TrelloURL.CARD_DELETE_VOTE_MEMBER, cardId, memberId).filter(filters);
		return getTrelloAccessor().doDelete(uri.build());
	}
}
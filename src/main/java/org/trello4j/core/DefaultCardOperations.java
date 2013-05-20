package org.trello4j.core;

import static java.lang.String.format;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.trello4j.Response;
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
		return getTrelloAccessor().doGet(Card.class, TrelloURL.CARD_URL, cardId);
	}

	@Override
	public List<Action> getActions() {
		ParameterizedTypeReference<List<Action>> typeReference = new ParameterizedTypeReference<List<Action>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.CARD_ACTION_URL, cardId);
	}

	@Override
	public List<Attachment> getAttachments() {
		ParameterizedTypeReference<List<Attachment>> typeReference = new ParameterizedTypeReference<List<Attachment>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.CARD_ATTACHEMENT_URL, cardId);
	}

	@Override
	public Board getBoard(final String... filters) {
		return getTrelloAccessor().doGet(Board.class, TrelloURL.CARD_BOARD_URL, cardId, filters);
	}

	@Override
	public List<CheckItem> getCheckItemStates() {
		ParameterizedTypeReference<List<CheckItem>> typeReference = new ParameterizedTypeReference<List<CheckItem>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.CARD_CHECK_ITEM_STATES_URL, cardId);
	}

	@Override
	public List<Checklist> getChecklist() {
		ParameterizedTypeReference<List<Checklist>> typeReference = new ParameterizedTypeReference<List<Checklist>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.CARD_CHECKLISTS_URL, cardId);
	}

	@Override
	public org.trello4j.model.List getList(final String... filters) {
		return getTrelloAccessor().doGet(org.trello4j.model.List.class, TrelloURL.CARD_LIST_URL, cardId, filters);
	}

	@Override
	public List<Member> getMembers() {
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.CARD_MEMBERS_URL, cardId);
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

		ParameterizedTypeReference<List<Attachment>> typeReference = new ParameterizedTypeReference<List<Attachment>>() {
		};
		return getTrelloAccessor().doPost(typeReference, TrelloURL.CARD_POST_ATTACHMENTS, cardId, keyValueMap, filters);
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
		return getTrelloAccessor().doPost(Checklist.class, TrelloURL.CARD_POST_CHECKLISTS, cardId, keyValueMap, filters);
	}

	@Override
	public List<Label> addLabel(String label, String... filters) {
		Map<String, String> keyValueMap = Collections.singletonMap("value", label);

		ParameterizedTypeReference<List<Label>> typeReference = new ParameterizedTypeReference<List<Label>>() {
		};
		return getTrelloAccessor().doPost(typeReference, TrelloURL.CARD_POST_LABELS, cardId, keyValueMap, filters);
	}

	@Override
	public List<Member> addMember(String memberId, String... filters) {
		Map<String, String> keyValueMap = Collections.singletonMap("value", memberId);

		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doPost(typeReference, TrelloURL.CARD_POST_ADD_MEMBER, cardId, keyValueMap, filters);
	}

	// TODO
	@Override
	public boolean vote(String memberId, String... filter) {
		final String url = TrelloURL.create(getTrelloAccessor().apiKey, TrelloURL.CARD_POST_VOTE_MEMBER, cardId).token(getTrelloAccessor().accessToken).filter(filter).build();
		System.out.println(url);

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("value", memberId);

		Response response = doPostWithResponse(url, keyValueMap);

		System.out.println(response.getResponseBody());

		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not vote on card: %s", response.getResponseBody()));
			return false;
		}

	}

	@Override
	public List<Member> getMemberVotes(String... filters) {
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.CARD_GET_VOTES, cardId, filters);
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
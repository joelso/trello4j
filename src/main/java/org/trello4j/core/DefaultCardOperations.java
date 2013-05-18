package org.trello4j.core;

import static java.lang.String.format;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.trello4j.Response;
import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURL;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Card.Attachment;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;
import org.trello4j.model.Member;

import com.google.gson.reflect.TypeToken;

public class DefaultCardOperations extends AbstractOperations implements CardOperations {

	private final String cardId;

	DefaultCardOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory, String cardId) {
		super(apiKey, token, trelloObjFactory);
		validateObjectId(cardId);
		this.cardId = cardId;
	}

	@Override
	public Card get() {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Card>() {
		}, doGet(url));
	}

	@Override
	public List<Action> getActions() {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_ACTION_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Action>>() {
		}, doGet(url));
	}

	@Override
	public List<Attachment> getAttachments() {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_ATTACHEMENT_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Attachment>>() {
		}, doGet(url));
	}

	@Override
	public Board getBoard(final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_BOARD_URL, cardId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doGet(url));
	}

	@Override
	public List<CheckItem> getCheckItemStates() {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_CHECK_ITEM_STATES_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<CheckItem>>() {
		}, doGet(url));
	}

	@Override
	public List<Checklist> getChecklist() {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_CHECKLISTS_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Checklist>>() {
		}, doGet(url));
	}

	@Override
	public org.trello4j.model.List getList(final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_LIST_URL, cardId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<org.trello4j.model.List>() {
		}, doGet(url));
	}

	@Override
	public List<Member> getMembers() {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_MEMBERS_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doGet(url));
	}

	@Override
	public Action comment(String text, String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_COMMENTS, cardId).token(token).filter(filter).build();
		Map<String, Object> keyValuMap = new HashMap<String, Object>();
		keyValuMap.put("text", text);
		return trelloObjFactory.createObject(new TypeToken<Action>() {
		}, doPost(url, keyValuMap));
	}

	@Override
	public List<Attachment> attach(File file, URL attachmentUrl, String name, String mimeType, String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_ATTACHMENTS, cardId).token(token).filter(filter).build();

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		if (file != null)
			keyValueMap.put("file", file);
		if (attachmentUrl != null)
			keyValueMap.put("url", attachmentUrl.toString());
		if (name != null)
			keyValueMap.put("name", name);
		if (mimeType != null)
			keyValueMap.put("mimeType", mimeType);

		return trelloObjFactory.createObject(new TypeToken<List<Attachment>>() {
		}, doPost(url, keyValueMap));
	}

	@Override
	public Checklist addChecklist(String checklistId, String checklistName, String idChecklistSource, String... filter) {
		if (checklistId != null) {
			validateObjectId(checklistId);
		}

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_CHECKLISTS, cardId).token(token).filter(filter).build();

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("name", checklistName == null ? "Checklist" : checklistName);
		if (checklistId != null)
			keyValueMap.put("value", checklistId);
		if (idChecklistSource != null)
			keyValueMap.put("idChecklistSource", idChecklistSource);

		return trelloObjFactory.createObject(new TypeToken<Checklist>() {
		}, doPost(url, keyValueMap));
	}

	@Override
	public List<Card.Label> addLabel(String label, String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_LABELS, cardId).token(token).filter(filter).build();

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("value", label);
		return trelloObjFactory.createObject(new TypeToken<List<Card.Label>>() {
		}, doPost(url, keyValueMap));
	}

	@Override
	public List<Member> addMember(String memberId, String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_ADD_MEMBER, cardId).token(token).filter(filter).build();

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("value", memberId);

		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doPost(url, keyValueMap));
	}

	@Override
	public boolean vote(String memberId, String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_VOTE_MEMBER, cardId).token(token).filter(filter).build();

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("value", memberId);

		Response response = doPostWithResponse(url, keyValueMap);

		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not vote on card: %s", response.getResponseBody()));
			return false;
		}
	}

	@Override
	public List<Member> getMemberVotes(String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_GET_VOTES, cardId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doGet(url));
	}

	@Override
	public boolean delete(String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_CARD, cardId).token(token).filter(filter).build();

		Response response = doDelete(url);
		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not delete card %s: %s", cardId, response.getResponseBody()));
			return false;
		}
	}

	@Override
	public boolean deleteChecklist(String idList, String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_CHECKLIST, cardId, idList).token(token).filter(filter).build();

		Response response = doDelete(url);
		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.printf(format("Could not remove checklist %s from card: %s", idList, response.getResponseBody()));
			return false;
		}
	}

	@Override
	public boolean deleteLabel(String color, String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_LABEL, cardId, color).token(token).filter(filter).build();
		Response response = doDelete(url);
		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not remove %s label from card: %s", color, response.getResponseBody()));
			return false;
		}
	}

	@Override
	public boolean deleteMember(String memberId, String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_MEMBER, cardId, memberId).token(token).filter(filter).build();
		Response response = doDelete(url);
		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not remove member from card: %s", response.getResponseBody()));
			return false;
		}
	}

	@Override
	public boolean deleteVote(String memberId, String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_VOTE_MEMBER, cardId, memberId).token(token).filter(filter).build();

		Response response = doDelete(url);

		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not remove vote from card: %s", response.getResponseBody()));
			return false;
		}
	}
}
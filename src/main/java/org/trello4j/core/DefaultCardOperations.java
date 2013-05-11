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

	public DefaultCardOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Card getCard(final String cardId) {
		validateObjectId(cardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Card>() {
		}, doGet(url));
	}

	@Override
	public List<Action> getActionsByCard(final String cardId) {
		validateObjectId(cardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_ACTION_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Action>>() {
		}, doGet(url));
	}

	@Override
	public List<Attachment> getAttachmentsByCard(final String cardId) {
		validateObjectId(cardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_ATTACHEMENT_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Attachment>>() {
		}, doGet(url));
	}

	@Override
	public Board getBoardByCard(final String cardId, final String... filter) {
		validateObjectId(cardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_BOARD_URL, cardId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doGet(url));
	}

	@Override
	public List<CheckItem> getCheckItemStatesByCard(final String cardId) {
		validateObjectId(cardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_CHECK_ITEM_STATES_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<CheckItem>>() {
		}, doGet(url));
	}

	@Override
	public List<Checklist> getChecklistByCard(final String cardId) {
		validateObjectId(cardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_CHECKLISTS_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Checklist>>() {
		}, doGet(url));
	}

	@Override
	public org.trello4j.model.List getListByCard(final String cardId, final String... filter) {
		validateObjectId(cardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_LIST_URL, cardId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<org.trello4j.model.List>() {
		}, doGet(url));
	}

	@Override
	public List<Member> getMembersByCard(final String cardId) {
		validateObjectId(cardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_MEMBERS_URL, cardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doGet(url));
	}

	@Override
	public Card createCard(String idList, String name, Map<String, Object> keyValueMap, String... filter) {
		validateObjectId(idList);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_URL).token(token).filter(filter).build();
		if (keyValueMap == null)
			keyValueMap = new HashMap<String, Object>();
		// if (keyValueMap.containsKey("name")) keyValueMap.remove("name");
		keyValueMap.put("name", name);
		keyValueMap.put("idList", idList);

		return trelloObjFactory.createObject(new TypeToken<Card>() {
		}, doPost(url, keyValueMap));
	}

	@Override
	public Action commentOnCard(String idCard, String text, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_COMMENTS, idCard).token(token).filter(filter).build();
		Map<String, Object> keyValuMap = new HashMap<String, Object>();
		keyValuMap.put("text", text);
		return trelloObjFactory.createObject(new TypeToken<Action>() {
		}, doPost(url, keyValuMap));
	}

	@Override
	public List<Attachment> attachToCard(String idCard, File file, URL attachmentUrl, String name, String mimeType, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_ATTACHMENTS, idCard).token(token).filter(filter).build();

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
	public Checklist addChecklist(String idCard, String idChecklist, String checklistName, String idChecklistSource, String... filter) {
		validateObjectId(idCard);
		if (idChecklist != null) {
			validateObjectId(idChecklist);
		}

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_CHECKLISTS, idCard).token(token).filter(filter).build();

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("name", checklistName == null ? "Checklist" : checklistName);
		if (idChecklist != null)
			keyValueMap.put("value", idChecklist);
		if (idChecklistSource != null)
			keyValueMap.put("idChecklistSource", idChecklistSource);

		return trelloObjFactory.createObject(new TypeToken<Checklist>() {
		}, doPost(url, keyValueMap));
	}

	@Override
	public List<Card.Label> addLabel(String idCard, String label, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_LABELS, idCard).token(token).filter(filter).build();

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("value", label);
		return trelloObjFactory.createObject(new TypeToken<List<Card.Label>>() {
		}, doPost(url, keyValueMap));
	}

	@Override
	public List<Member> addMember(String idCard, String memberId, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_ADD_MEMBER, idCard).token(token).filter(filter).build();

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("value", memberId);

		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doPost(url, keyValueMap));
	}

	@Override
	public boolean voteOnCard(String idCard, String memberId, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_POST_VOTE_MEMBER, idCard).token(token).filter(filter).build();

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
	public List<Member> getMemberVotesOnCard(String idCard, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_GET_VOTES, idCard).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doGet(url));
	}

	@Override
	public boolean deleteCard(String idCard, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_CARD, idCard).token(token).filter(filter).build();

		Response response = doDelete(url);
		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not delete card %s: %s", idCard, response.getResponseBody()));
			return false;
		}
	}

	@Override
	public boolean deleteChecklistFromCard(String idCard, String idList, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_CHECKLIST, idCard, idList).token(token).filter(filter).build();

		Response response = doDelete(url);
		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.printf(format("Could not remove checklist %s from card: %s", idList, response.getResponseBody()));
			return false;
		}
	}

	@Override
	public boolean deleteLabelFromCard(String idCard, String color, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_LABEL, idCard, color).token(token).filter(filter).build();
		Response response = doDelete(url);
		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not remove %s label from card: %s", color, response.getResponseBody()));
			return false;
		}
	}

	@Override
	public boolean deleteMemberFromCard(String idCard, String idMember, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_MEMBER, idCard, idMember).token(token).filter(filter).build();
		Response response = doDelete(url);
		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not remove member from card: %s", response.getResponseBody()));
			return false;
		}
	}

	@Override
	public boolean deleteVoteFromCard(String idCard, String memberId, String... filter) {
		validateObjectId(idCard);

		final String url = TrelloURL.create(apiKey, TrelloURL.CARD_DELETE_VOTE_MEMBER, idCard, memberId).token(token).filter(filter).build();

		Response response = doDelete(url);

		if (response.getCode() < 400) {
			return true;
		} else {
			System.err.println(format("Could not remove vote from card: %s", response.getResponseBody()));
			return false;
		}
	}

}

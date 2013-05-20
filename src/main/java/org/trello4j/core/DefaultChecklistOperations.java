package org.trello4j.core;

import java.util.List;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURI;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;

import com.google.gson.reflect.TypeToken;

public class DefaultChecklistOperations extends AbstractOperations implements ChecklistOperations {

	DefaultChecklistOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
	}

	@Override
	public Checklist getChecklist(String checklistId, final String... filter) {
		validateObjectId(checklistId);

		final String url = TrelloURI.create(apiKey, TrelloURI.CHECKLIST_URL, checklistId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Checklist>() {
		}, doGet(url));
	}

	@Override
	public Board getBoardByChecklist(String checklistId, final String... filter) {
		validateObjectId(checklistId);

		final String url = TrelloURI.create(apiKey, TrelloURI.CHECKLIST_BOARD_URL, checklistId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doGet(url));
	}

	@Override
	public List<CheckItem> getCheckItemsByChecklist(String checklistId) {
		validateObjectId(checklistId);

		final String url = TrelloURI.create(apiKey, TrelloURI.CHECKLIST_CHECKITEMS_URL, checklistId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<CheckItem>>() {
		}, doGet(url));
	}

	@Override
	public List<Card> getCardByChecklist(String checklistId, final String... filter) {
		validateObjectId(checklistId);

		final String url = TrelloURI.create(apiKey, TrelloURI.CHECKLIST_CARDS_URL, checklistId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Card>>() {
		}, doGet(url));
	}

}

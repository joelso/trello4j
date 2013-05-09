package org.trello4j.core;

import java.util.List;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURL;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;

import com.google.gson.reflect.TypeToken;

public class DefaultChecklistOperations extends AbstractOperations implements ChecklistOperations {

	public DefaultChecklistOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Checklist getChecklist(String checklistId, final String... filter) {
		validateObjectId(checklistId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CHECKLIST_URL, checklistId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Checklist>() {
		}, doGet(url));
	}

	@Override
	public Board getBoardByChecklist(String checklistId, final String... filter) {
		validateObjectId(checklistId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CHECKLIST_BOARD_URL, checklistId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doGet(url));
	}

	@Override
	public List<CheckItem> getCheckItemsByChecklist(String checklistId) {
		validateObjectId(checklistId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CHECKLIST_CHECKITEMS_URL, checklistId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<CheckItem>>() {
		}, doGet(url));
	}

	@Override
	public List<Card> getCardByChecklist(String checklistId, final String... filter) {
		validateObjectId(checklistId);

		final String url = TrelloURL.create(apiKey, TrelloURL.CHECKLIST_CARDS_URL, checklistId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Card>>() {
		}, doGet(url));
	}

}

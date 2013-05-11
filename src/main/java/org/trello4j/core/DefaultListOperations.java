package org.trello4j.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURL;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;

import com.google.gson.reflect.TypeToken;

public class DefaultListOperations extends AbstractOperations implements ListOperations {

	DefaultListOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
	}

	@Override
	public org.trello4j.model.List getList(final String listId) {
		validateObjectId(listId);

		final String url = TrelloURL.create(apiKey, TrelloURL.LIST_URL, listId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<org.trello4j.model.List>() {
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
	public List<Action> getActionsByList(String listId) {
		validateObjectId(listId);

		final String url = TrelloURL.create(apiKey, TrelloURL.LIST_ACTIONS_URL, listId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Action>>() {
		}, doGet(url));
	}

	@Override
	public Board getBoardByList(String listId, final String... filter) {
		validateObjectId(listId);

		final String url = TrelloURL.create(apiKey, TrelloURL.LIST_BOARD_URL, listId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doGet(url));
	}

	@Override
	public List<Card> getCardsByList(String listId, final String... filter) {
		validateObjectId(listId);

		final String url = TrelloURL.create(apiKey, TrelloURL.LIST_CARDS_URL, listId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Card>>() {
		}, doGet(url));
	}

}

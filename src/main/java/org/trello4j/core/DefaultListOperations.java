package org.trello4j.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.trello4j.TrelloURI;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;

public class DefaultListOperations extends AbstractOperations implements ListOperations {

	private final String listId;

	public DefaultListOperations(String listId, TrelloAccessor trelloAccessor) {
		super(trelloAccessor);
		validateObjectId(listId);
		this.listId = listId;
	}

	@Override
	public org.trello4j.model.List get() {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.LIST_URL, listId);
		return getTrelloAccessor().doGet(uri.build(), org.trello4j.model.List.class);
	}

	/**
	 * @param name
	 *            (required)
	 * @param desc
	 *            (optional)
	 * @param due
	 *            (required - Valid Values: A date, or null)
	 * @param pos
	 *            (optional - Default: bottom; Valid Values: A position. top,
	 *            bottom, or a positive number.)
	 * @param label
	 *            (optional - Valid Values: Green, yellow, orange, red, purple)
	 * @param cardSource
	 *            (optional - Valid Values: The id of the card to copy into a
	 *            new card.)
	 * @param memberId
	 *            (optional - Valid Values: A comma-separated list of objectIds,
	 *            24-character hex strings)
	 * @param keepFromSource
	 *            (optional - Default: all; Valid Values: Properties of the card
	 *            to copy over from the source.)
	 * @return
	 */
	@Override
	public Card createCard(String name, String desc, String due, String pos, String labels, String memberId, String cardSourceId, String keepFromSource) {
		validateNotNull(name);

		Map<String, Object> keyValueMap = new HashMap<String, Object>();
		keyValueMap.put("idList", listId);
		keyValueMap.put("name", name);
		keyValueMap.put("due", due);
		if (desc != null) {
			keyValueMap.put("desc", desc);
		}
		if (pos != null) {
			keyValueMap.put("pos", pos);
		}
		if (labels != null) {
			keyValueMap.put("labels", labels);
		}
		if (memberId != null) {
			keyValueMap.put("idMembers", memberId);
		}
		if (cardSourceId != null) {
			keyValueMap.put("idCardSource", cardSourceId);
		}
		if (keepFromSource != null) {
			keyValueMap.put("keepFromSource", keepFromSource);
		}

		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.CARD_POST_URL);
		return getTrelloAccessor().doPost(uri.build(), keyValueMap, Card.class);
	}

	@Override
	public List<Action> getActions() {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.LIST_ACTIONS_URL, listId);
		ParameterizedTypeReference<List<Action>> typeReference = new ParameterizedTypeReference<List<Action>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public Board getBoard(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.LIST_BOARD_URL, listId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Board.class);
	}

	@Override
	public List<Card> getCards(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.LIST_CARDS_URL, listId).filter(filters);
		ParameterizedTypeReference<List<Card>> typeReference = new ParameterizedTypeReference<List<Card>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

}

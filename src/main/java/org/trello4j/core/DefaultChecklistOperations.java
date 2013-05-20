package org.trello4j.core;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.trello4j.TrelloURI;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;

public class DefaultChecklistOperations extends AbstractOperations implements ChecklistOperations {

	private final String checklistId;

	public DefaultChecklistOperations(String checklistId, TrelloAccessor trelloAccessor) {
		super(trelloAccessor);
		validateObjectId(checklistId);
		this.checklistId = checklistId;
	}

	@Override
	public Checklist get(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.CHECKLIST_URL, checklistId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Checklist.class);
	}

	@Override
	public Board getBoard(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.CHECKLIST_BOARD_URL, checklistId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Board.class);
	}

	@Override
	public List<CheckItem> getCheckItems() {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.CHECKLIST_CHECKITEMS_URL, checklistId);
		ParameterizedTypeReference<List<CheckItem>> typeReference = new ParameterizedTypeReference<List<CheckItem>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Card> getCard(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.CHECKLIST_CARDS_URL, checklistId).filter(filters);
		ParameterizedTypeReference<List<Card>> typeReference = new ParameterizedTypeReference<List<Card>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

}

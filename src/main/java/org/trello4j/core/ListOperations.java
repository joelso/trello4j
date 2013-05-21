package org.trello4j.core;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.List;

public interface ListOperations {

	List get();

	java.util.List<Action> getActions();

	Board getBoard(String... filters);

	java.util.List<Card> getCards(String... filters);

	Card createCard(String name, String desc, String due, String pos, String labels, String memberId, String cardSourceId, String keepFromSource);

}
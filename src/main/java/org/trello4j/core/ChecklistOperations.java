package org.trello4j.core;

import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;

public interface ChecklistOperations {

	Checklist get(String... filter);

	Board getBoard(String... filter);

	java.util.List<Card> getCard(String... filter);

	java.util.List<CheckItem> getCheckItems();
}
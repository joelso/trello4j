package org.trello4j.core;

import org.trello4j.TrelloException;
import org.trello4j.TrelloUtil;

abstract class AbstractOperations {

	private TrelloAccessor trelloAccessor;

	AbstractOperations(TrelloAccessor trelloAccessor) {
		this.trelloAccessor = trelloAccessor;
	}

	TrelloAccessor getTrelloAccessor() {
		return trelloAccessor;
	}

	void validateObjectId(String id) {
		if (!TrelloUtil.isObjectIdValid(id)) {
			throw new TrelloException("Invalid object id: " + id);
		}
	}

	void validateNotNull(String... values) {
		for (String value : values) {
			if (value == null) {
				throw new IllegalArgumentException("Value must not be null.");
			}
		}
	}
}

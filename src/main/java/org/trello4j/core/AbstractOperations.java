package org.trello4j.core;

import org.trello4j.TrelloException;

abstract class AbstractOperations {

	private TrelloAccessor trelloAccessor;

	AbstractOperations(TrelloAccessor trelloAccessor) {
		this.trelloAccessor = trelloAccessor;
	}

	TrelloAccessor getTrelloAccessor() {
		return trelloAccessor;
	}

	void validateObjectId(String id) {
		if (!isObjectIdValid(id)) {
			throw new TrelloException("Invalid object id: " + id);
		}
	}

	boolean isObjectIdValid(String s) {
		if (s == null)
			return false;

		final int len = s.length();
		if (len != 24)
			return false;

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				continue;
			}
			if (c >= 'a' && c <= 'f') {
				continue;
			}
			if (c >= 'A' && c <= 'F') {
				continue;
			}
			return false;
		}

		return true;
	}

	void validateNotNull(String... values) {
		for (String value : values) {
			if (value == null) {
				throw new IllegalArgumentException("Value must not be null.");
			}
		}
	}
}

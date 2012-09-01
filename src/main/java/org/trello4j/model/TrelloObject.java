package org.trello4j.model;

/**
 * Base class for a Trello object.
 */
public abstract class TrelloObject {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return new StringBuilder(getClass().getSimpleName())
				.append(" ")
				.append(id)
				.toString();
	}
}

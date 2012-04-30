package org.trello4j.model;


/**
 * The Class TrelloObject.
 */
public abstract class TrelloObject {
	
	/** The id. */
	private String id;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder(getClass().getSimpleName())
			.append(" ")
			.append(id)
			.toString();
	}
}

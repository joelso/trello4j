package org.trello4j.core;

import org.trello4j.model.Type;

public interface TypeOperations {

	/**
	 * Gets the type.
	 * 
	 * @param idOrName
	 *            the id or name
	 * @return the type
	 */
	public abstract Type getType(String idOrName);

}
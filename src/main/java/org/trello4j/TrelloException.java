package org.trello4j;

/**
 * The Class TrelloException.
 */
public class TrelloException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7427993543996731840L;

	/**
	 * Instantiates a new trello exception.
	 */
	public TrelloException() {
		super();
	}

	/**
	 * Instantiates a new trello exception.
	 * 
	 * @param msg
	 *            the msg
	 */
	public TrelloException(String msg) {
		super(msg);
	}

}

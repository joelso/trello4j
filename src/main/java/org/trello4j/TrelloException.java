package org.trello4j;

public class TrelloException extends RuntimeException {

	private static final long serialVersionUID = 7427993543996731840L;
	
	public TrelloException() { 
		super();
	}
	
	public TrelloException(String msg) {
		super(msg);
	}
	
}

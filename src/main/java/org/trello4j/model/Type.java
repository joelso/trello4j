package org.trello4j.model;

/**
 * Trello type. Represent response of a GET /1/types/[id] request. This is
 * simply a way of getting the type of given id or name.
 * 
 * See TrelloType for different kinds of types.
 * 
 * <code>
 * {
 * 	"id":"4eb3f3f1e679eb839b4c594b",
 * 	"type":"organization"
 * }
 * </code>
 * 
 * @author joel
 * 
 */
public class Type extends TrelloObject {

	private TrelloType type;

	public TrelloType getType() {
		return type;
	}

	public void setType(TrelloType type) {
		this.type = type;
	}
}

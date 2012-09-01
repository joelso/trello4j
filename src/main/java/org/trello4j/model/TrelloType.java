package org.trello4j.model;

/**
 * Created with IntelliJ IDEA. User: Joel Soderstrom
 * (joel[at]frostdigital[dot]se) Date: 2012-04-22 Time: 4:20 PM
 */
public enum TrelloType {

	ORGANIZATION,
	ACTION,
	BOARD,
	CHECKLIST,
	LIST,
	MEMBER,
	NOTIFICATION,
	UNKNOWN;

	private TrelloType() {
	}

	public static TrelloType fromString(String str) {
		TrelloType type = TrelloType.UNKNOWN;
		try {
			type = TrelloType.valueOf(str.toUpperCase());
		} catch (Exception e) {
			// do nothing
		}
		return type;
	}
}
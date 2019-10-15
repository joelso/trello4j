package org.trello4j.model;

/**
 * <code>
 * {
 * 	"id":"4e7b86d7ce194786721560b8",
 * 	"name":"Known Issues",
 * 	"closed":false,
 * 	"idBoard":"4d5ea62fd76aa1136000000c",
 * 	"pos":9408.2119140625
 * }
 * </code>
 *
 * @author joel
 *
 */
public class Label extends TrelloObject {

	/** The name. */
	private String name;

	/** The closed. */
	private String color;

	/** The id board. */
	private String idBoard;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the id board.
	 *
	 * @return the id board
	 */
	public String getIdBoard() {
		return idBoard;
	}

	/**
	 * Sets the id board.
	 *
	 * @param idBoard
	 *            the new id board
	 */
	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}


}

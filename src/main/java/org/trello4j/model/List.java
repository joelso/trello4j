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
public class List extends TrelloObject {
	
	private String name;
	private boolean closed;
	private String idBoard;
	private double pos;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isClosed() {
		return closed;
	}
	
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	
	public String getIdBoard() {
		return idBoard;
	}
	
	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}
	
	public double getPos() {
		return pos;
	}

	public void setPos(double pos) {
		this.pos = pos;
	}
	
	
}

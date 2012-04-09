package org.trello4j.model;

import java.util.Date;

/**
 * <code>
 * {
 * 	"id":"4f7f3809301cb98a5346bb50",
 * 	"idMemberCreator":"4f7d84acffdbe931585331bd",
 * 	"data":{
 * 		"text":"Adn can you make the checklists appear in the order I want and not in alphabetical order...",
 * 		"board":{
 * 			"name":"Trello Development",
 * 			"id":"4d5ea62fd76aa1136000000c"
 * 		},
 * 		"card":{
 * 			"name":"Assign people and due dates to specific checklist items.",
 * 			"id":"4f455a15dfe503f23316557f"
 * 		}
 * 	},
 * 	"type":"commentCard",
 * 	"date":"2012-04-06T18:38:01.791Z",
 * 	"memberCreator":{
 * 		"id":"4f7d84acffdbe931585331bd",
 * 		"username":"borishanreich",
 * 		"fullName":"Boris Hanreich",
 * 		"initials":"BH"
 * 		}
 *	}
 * </code>
 * 
 * @author joel
 *
 */
public class Action extends TrelloObject {
	
	private String idMemberCreator;
	private String type;
	private Date date;
	private Member memberCreator;
	private Data data;
	
	public String getIdMemberCreator() {
		return idMemberCreator;
	}

	public void setIdMemberCreator(String idMemberCreator) {
		this.idMemberCreator = idMemberCreator;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Member getMemberCreator() {
		return memberCreator;
	}
	
	public void setMemberCreator(Member memberCreator) {
		this.memberCreator = memberCreator;
	}
	
	public Data getData() {
		return data;
	}
	
	public void setData(Data data) {
		this.data = data;
	}
	
	public class Data {
		private String text;
		private Board board;
		private Card card;
		
		public String getText() {
			return text;
		}
		
		public void setText(String text) {
			this.text = text;
		}

		public Board getBoard() {
			return board;
		}
		
		public void setBoard(Board board) {
			this.board = board;
		}
		
		public Card getCard() {
			return card;
		}
		
		public void setCard(Card card) {
			this.card = card;
		}
	}
	
	
}

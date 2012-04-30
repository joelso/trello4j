package org.trello4j.model;

import java.util.Date;


/**
 * Model that represents a user action @ Trello.
 *
 * Example json:
 *
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
 * 		"username":"foobar",
 * 		"fullName":"Foo Bar",
 * 		"initials":"FB"
 * 		}
 *	}
 * </code>
 * 
 * @author joel
 *
 */
public class Action extends TrelloObject {

    /** The id member creator. */
    private String idMemberCreator;
	
	/** The type. */
	private String type;
	
	/** The date. */
	private Date date;
	
	/** The member creator. */
	private Member memberCreator;
	
	/** The data. */
	private Data data;
	
	/**
	 * Gets the id member creator.
	 *
	 * @return the id member creator
	 */
	public String getIdMemberCreator() {
		return idMemberCreator;
	}

	/**
	 * Sets the id member creator.
	 *
	 * @param idMemberCreator the new id member creator
	 */
	public void setIdMemberCreator(String idMemberCreator) {
		this.idMemberCreator = idMemberCreator;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Gets the member creator.
	 *
	 * @return the member creator
	 */
	public Member getMemberCreator() {
		return memberCreator;
	}
	
	/**
	 * Sets the member creator.
	 *
	 * @param memberCreator the new member creator
	 */
	public void setMemberCreator(Member memberCreator) {
		this.memberCreator = memberCreator;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Data getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Data data) {
		this.data = data;
	}
	
	/**
	 * The Class Data.
	 */
	public class Data {
		
		/** The text. */
		private String text;
		
		/** The board. */
		private Board board;
		
		/** The card. */
		private Card card;
		
		/**
		 * Gets the text.
		 *
		 * @return the text
		 */
		public String getText() {
			return text;
		}
		
		/**
		 * Sets the text.
		 *
		 * @param text the new text
		 */
		public void setText(String text) {
			this.text = text;
		}

		/**
		 * Gets the board.
		 *
		 * @return the board
		 */
		public Board getBoard() {
			return board;
		}
		
		/**
		 * Sets the board.
		 *
		 * @param board the new board
		 */
		public void setBoard(Board board) {
			this.board = board;
		}
		
		/**
		 * Gets the card.
		 *
		 * @return the card
		 */
		public Card getCard() {
			return card;
		}
		
		/**
		 * Sets the card.
		 *
		 * @param card the new card
		 */
		public void setCard(Card card) {
			this.card = card;
		}
	}

    /**
     * The Class TYPE.
     */
    public static class TYPE {

        /** The Constant CREATE_CARD. */
        public static final String CREATE_CARD = "createCard";

        /** The Constant COMMENT_CARD. */
        public static final String COMMENT_CARD = "commentCard";

        /** The Constant UPDATE_CARD. */
        public static final String UPDATE_CARD = "updateCard";

        /** The Constant UPDATE_CARD_ID_LIST. */
        public static final String UPDATE_CARD_ID_LIST = "updateCard:idList";

        /** The Constant UPDATE_CARD_CLOSED. */
        public static final String UPDATE_CARD_CLOSED = "updateCard:closed";

        /** The Constant UPDATE_CARD_DESC. */
        public static final String UPDATE_CARD_DESC = "updateCard:desc";

        /** The Constant UPDATE_CARD_NAME. */
        public static final String UPDATE_CARD_NAME = "updateCard:name";

        /** The Constant ADD_MEMBER_TO_CARD. */
        public static final String ADD_MEMBER_TO_CARD = "addMemberToCard";

        /** The Constant REMOVE_MEMBER_FROM_CARD. */
        public static final String REMOVE_MEMBER_FROM_CARD = "removeMemberFromCard";

        /** The Constant UPDATE_CHECK_ITEM. */
        public static final String UPDATE_CHECK_ITEM = "updateCheckItemStateOnCard";

        /** The Constant ADD_ATTACHMENT. */
        public static final String ADD_ATTACHMENT = "addAttachmentToCard";

        /** The Constant REMOVE_ATTACHMENT. */
        public static final String REMOVE_ATTACHMENT = "removeAttachmentFromCard";

        /** The Constant ADD_CHECKLIST. */
        public static final String ADD_CHECKLIST = "addChecklistToCard";

        /** The Constant REMOVE_CHECKLIST. */
        public static final String REMOVE_CHECKLIST = "removeChecklistFromCard";

        /** The Constant CREATE_LIST. */
        public static final String CREATE_LIST = "createList";

        /** The Constant UPDATE_LIST. */
        public static final String UPDATE_LIST = "updateList";

        /** The Constant CREATE_BOARD. */
        public static final String CREATE_BOARD = "createBoard";

        /** The Constant UPDATE_BOARD. */
        public static final String UPDATE_BOARD = "updateBoard";

        /** The Constant ADD_MEMBER_TO_BOARD. */
        public static final String ADD_MEMBER_TO_BOARD = "addMemberToBoard";

        /** The Constant REMOVE_MEMBER_FROM_BOARD. */
        public static final String REMOVE_MEMBER_FROM_BOARD = "removeMemberFromBoard";

        /** The Constant ADD_TO_ORGANIZATION_BOARD. */
        public static final String ADD_TO_ORGANIZATION_BOARD = "addToOrganizationBoard";

        /** The Constant REMOVE_FROM_ORGANIZATION_BOARD. */
        public static final String REMOVE_FROM_ORGANIZATION_BOARD = "removeFromOrganizationBoard";

        /** The Constant CREATE_ORGANIZATION. */
        public static final String CREATE_ORGANIZATION ="createOrganization";

        /** The Constant UPDATE_ORGANIZATION. */
        public static final String UPDATE_ORGANIZATION ="updateOrganization";

    }
	
}

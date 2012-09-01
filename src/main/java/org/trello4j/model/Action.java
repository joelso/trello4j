package org.trello4j.model;

import java.util.Date;

/**
 * Model that represents a user action @ Trello.
 * <p/>
 * Example json:
 * <p/>
 * <code>
 * {
 * "id":"4f7f3809301cb98a5346bb50",
 * "idMemberCreator":"4f7d84acffdbe931585331bd",
 * "data":{
 * "text":"Adn can you make the checklists appear in the order I want and not in alphabetical order...",
 * "board":{
 * "name":"Trello Development",
 * "id":"4d5ea62fd76aa1136000000c"
 * },
 * "card":{
 * "name":"Assign people and due dates to specific checklist items.",
 * "id":"4f455a15dfe503f23316557f"
 * }
 * },
 * "type":"commentCard",
 * "date":"2012-04-06T18:38:01.791Z",
 * "memberCreator":{
 * "id":"4f7d84acffdbe931585331bd",
 * "username":"foobar",
 * "fullName":"Foo Bar",
 * "initials":"FB"
 * }
 * }
 * </code>
 *
 * @author joel
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


    public static class TYPE {

        public static final String CREATE_CARD = "createCard";
        public static final String COMMENT_CARD = "commentCard";
        public static final String UPDATE_CARD = "updateCard";
        public static final String UPDATE_CARD_ID_LIST = "updateCard:idList";
        public static final String UPDATE_CARD_CLOSED = "updateCard:closed";
        public static final String UPDATE_CARD_DESC = "updateCard:desc";
        public static final String UPDATE_CARD_NAME = "updateCard:name";
        public static final String ADD_MEMBER_TO_CARD = "addMemberToCard";
        public static final String REMOVE_MEMBER_FROM_CARD = "removeMemberFromCard";
        public static final String UPDATE_CHECK_ITEM = "updateCheckItemStateOnCard";
        public static final String ADD_ATTACHMENT = "addAttachmentToCard";
        public static final String REMOVE_ATTACHMENT = "removeAttachmentFromCard";
        public static final String ADD_CHECKLIST = "addChecklistToCard";
        public static final String REMOVE_CHECKLIST = "removeChecklistFromCard";
        public static final String CREATE_LIST = "createList";
        public static final String UPDATE_LIST = "updateList";
        public static final String CREATE_BOARD = "createBoard";
        public static final String UPDATE_BOARD = "updateBoard";
        public static final String ADD_MEMBER_TO_BOARD = "addMemberToBoard";
        public static final String REMOVE_MEMBER_FROM_BOARD = "removeMemberFromBoard";
        public static final String ADD_TO_ORGANIZATION_BOARD = "addToOrganizationBoard";
        public static final String REMOVE_FROM_ORGANIZATION_BOARD = "removeFromOrganizationBoard";
        public static final String CREATE_ORGANIZATION = "createOrganization";
        public static final String UPDATE_ORGANIZATION = "updateOrganization";

    }

}

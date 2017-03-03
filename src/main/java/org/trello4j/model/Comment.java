package org.trello4j.model;

public class Comment extends TrelloObject {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

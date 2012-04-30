package org.trello4j.model;


/**
 * Created with IntelliJ IDEA.
 * User: Joel Soderstrom (joel[at]frostdigital[dot]se)
 * Date: 2012-04-22
 * Time: 4:20 PM
 */
public enum TrelloType {
    
    /** The ORGANIZATION. */
    ORGANIZATION,
    
    /** The ACTION. */
    ACTION,
    
    /** The BOARD. */
    BOARD,
    
    /** The CHECKLIST. */
    CHECKLIST,
    
    /** The LIST. */
    LIST,
    
    /** The MEMBER. */
    MEMBER,
    
    /** The NOTIFICATION. */
    NOTIFICATION,
    
    /** The UNKNOWN. */
    UNKNOWN;

    /**
     * Instantiates a new trello type.
     */
    private TrelloType() { }

    /**
     * From string.
     *
     * @param str the str
     * @return the trello type
     */
    public static TrelloType fromString(String str) {
        TrelloType type = TrelloType.UNKNOWN;
        try {
            type = TrelloType.valueOf(str.toUpperCase());
        } catch(Exception e) {
            // do nothing
        }
        return type;
    }
}
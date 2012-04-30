package org.trello4j.model;

import java.util.*;
import java.util.List;


/**
 * A Trello checklist.
 *
 * <code>
 *  {
 *    "id":"4f92b89ea73738db6cdd4ed7",
 *    "name":"Checklist",
 *    "idBoard":"4f92b80ba73738db6cdd4309",
 *    "checkItems":[
 *      {
 *        "id":"4f92b97cf9e2e2ae362df9ab",
 *        "name":"Base for filtering",
 *        "type":"check",
 *        "pos":8588
 *      },
 *      {
 *        "id":"4f92b99b5c92e5cd28006ee8",
 *        "name":"GET /1/boards/[board_id]/actions?filter",
 *        "type":"check",
 *        "pos":12882
 *       }
 *    ]
 *  }
 * </code>
 *
 */
public class Checklist extends TrelloObject {

    /** The name. */
    private String name;
    
    /** The id board. */
    private String idBoard;
    
    /** The check items. */
    private java.util.List<CheckItem> checkItems = new ArrayList<CheckItem>();

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
     * @param name the new name
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
     * @param idBoard the new id board
     */
    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    /**
     * Gets the check items.
     *
     * @return the check items
     */
    public List<CheckItem> getCheckItems() {
        return checkItems;
    }

    /**
     * Sets the check items.
     *
     * @param checkItems the new check items
     */
    public void setCheckItems(List<CheckItem> checkItems) {
        this.checkItems = checkItems;
    }

    /**
     * The Class CheckItem.
     */
    public class CheckItem extends TrelloObject {

        /** The name. */
        private String name;
        
        /** The type. */
        private String type;
        
        /** The pos. */
        private double pos;

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
         * @param name the new name
         */
        public void setName(String name) {
            this.name = name;
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
         * Gets the pos.
         *
         * @return the pos
         */
        public double getPos() {
            return pos;
        }

        /**
         * Sets the pos.
         *
         * @param pos the new pos
         */
        public void setPos(double pos) {
            this.pos = pos;
        }
    }
}

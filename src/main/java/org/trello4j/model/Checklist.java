package org.trello4j.model;

import java.util.ArrayList;
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

	private String name;

	private String idBoard;

	private java.util.List<CheckItem> checkItems = new ArrayList<CheckItem>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdBoard() {
		return idBoard;
	}

	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}

	public List<CheckItem> getCheckItems() {
		return checkItems;
	}

	public void setCheckItems(List<CheckItem> checkItems) {
		this.checkItems = checkItems;
	}

	public class CheckItem extends TrelloObject {

		private String name;
        private String type;
        private double pos;


        public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

        public double getPos() {
			return pos;
		}

		public void setPos(double pos) {
			this.pos = pos;
		}
	}
}

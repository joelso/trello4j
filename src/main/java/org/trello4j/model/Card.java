package org.trello4j.model;

import java.util.Date;
import java.util.List;



/**
 * <code>
 * {
 *     "id": "4f6b93de58843df908f6266a",
 *     "name": "Clicking a link in a popup notification opens the link in the popup.",
 *     "desc": "",
 *     "closed": false,
 *     "idShort": 1194,
 *     "idList": "4e7b86d7ce194786721560b8",
 *     "idBoard": "4d5ea62fd76aa1136000000c",
 *     "idMembers": [],
 *     "url": "https://trello.com/card/clicking-a-link-in-a-popup-notification-opens-the-link-in-the-popup/4d5ea62fd76aa1136000000c/1194",
 *     "attachments": [{
 *         "_id": "4f6b93ec58843df908f62cae",
 *         "bytes": 13907,
 *         "date": "2012-03-22T21:04:44.209Z",
 *         "url": "https://trello-attachments.s3.amazonaws.com/4d5ea62fd76aa1136000000c/4f6b93de58843df908f6266a/4UegPYIaK9ztvjHWfiTKa1sGiSIx/trellopopup.png",
 *         "name": "trellopopup.png",
 *         "idMember": "4d5ebae374a1fda761000453"
 *     }],
 *     "labels": [{
 *         "color": "red",
 *         "name": "Bug"
 *     }],
 *     "badges": {
 *         "votes": 1,
 *         "viewingMemberVoted": false,
 *         "due": null,
 *         "description": false,
 *         "attachments": 1,
 *         "comments": 3,
 *         "checkItemsChecked": 0,
 *         "checkItems": 0,
 *         "fogbugz": ""
 *     },
 *     "pos": 7804928,
 *     "idChecklists": [],
 *     "checkItemStates": []
 * }
 * </code>
 * 
 * @author joel
 *
 */
public class Card extends TrelloObject {
	
	// TODO: idChecklists
	// TODO: checkItemStates
	// TODO: badges

	/** The name. */
	private String name;
	
	/** The desc. */
	private String desc;
	
	/** The closed. */
	private boolean closed;
	
	/** The id short. */
	private Long idShort;
	
	/** The id list. */
	private String idList;
	
	/** The id board. */
	private String idBoard;
	
	/** The id members. */
	private List<String> idMembers;
	
	/** The attachments. */
	private List<Attachment> attachments;
	
	/** The labels. */
	private List<Label> labels;
	
	/** The url. */
	private String url;
	
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
	 * Gets the desc.
	 *
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * Sets the desc.
	 *
	 * @param desc the new desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * Checks if is closed.
	 *
	 * @return true, if is closed
	 */
	public boolean isClosed() {
		return closed;
	}
	
	/**
	 * Sets the closed.
	 *
	 * @param closed the new closed
	 */
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	
	/**
	 * Gets the id short.
	 *
	 * @return the id short
	 */
	public Long getIdShort() {
		return idShort;
	}
	
	/**
	 * Sets the id short.
	 *
	 * @param idShort the new id short
	 */
	public void setIdShort(Long idShort) {
		this.idShort = idShort;
	}
	
	/**
	 * Gets the id list.
	 *
	 * @return the id list
	 */
	public String getIdList() {
		return idList;
	}
	
	/**
	 * Sets the id list.
	 *
	 * @param idList the new id list
	 */
	public void setIdList(String idList) {
		this.idList = idList;
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
	 * Gets the id members.
	 *
	 * @return the id members
	 */
	public List<String> getIdMembers() {
		return idMembers;
	}
	
	/**
	 * Sets the id members.
	 *
	 * @param idMembers the new id members
	 */
	public void setIdMembers(List<String> idMembers) {
		this.idMembers = idMembers;
	}
	
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
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
	
	/**
	 * Gets the attachments.
	 *
	 * @return the attachments
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}
	
	/**
	 * Sets the attachments.
	 *
	 * @param attachments the new attachments
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	/**
	 * Gets the labels.
	 *
	 * @return the labels
	 */
	public List<Label> getLabels() {
		return labels;
	}
	
	/**
	 * Sets the labels.
	 *
	 * @param labels the new labels
	 */
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	
	/**
	 * <code>
	 * {
	 *   "_id": "4f6b93ec58843df908f62cae",
	 *   "bytes": 13907,
	 *   "date": "2012-03-22T21:04:44.209Z",
	 *   "url": "https://trello-attachments.s3.amazonaws.com/4d5ea62fd76aa1136000000c/4f6b93de58843df908f6266a/4UegPYIaK9ztvjHWfiTKa1sGiSIx/trellopopup.png",
	 *   "name": "trellopopup.png",
	 *   "idMember": "4d5ebae374a1fda761000453"
	 * }
	 * </code>
	 * 
	 * @author joel
	 *
	 */
	public class Attachment {
		
		/** The _id. */
		private String _id;
		
		/** The bytes. */
		private String bytes;
		
		/** The date. */
		private Date date;
		
		/** The url. */
		private String url;
		
		/** The name. */
		private String name;
		
		/** The id member. */
		private String idMember;
		
		/**
		 * Gets the _id.
		 *
		 * @return the _id
		 */
		public String get_id() {
			return _id;
		}
		
		/**
		 * Sets the _id.
		 *
		 * @param _id the new _id
		 */
		public void set_id(String _id) {
			this._id = _id;
		}
		
		/**
		 * Gets the bytes.
		 *
		 * @return the bytes
		 */
		public String getBytes() {
			return bytes;
		}
		
		/**
		 * Sets the bytes.
		 *
		 * @param bytes the new bytes
		 */
		public void setBytes(String bytes) {
			this.bytes = bytes;
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
		 * Gets the url.
		 *
		 * @return the url
		 */
		public String getUrl() {
			return url;
		}
		
		/**
		 * Sets the url.
		 *
		 * @param url the new url
		 */
		public void setUrl(String url) {
			this.url = url;
		}
		
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
		 * Gets the id member.
		 *
		 * @return the id member
		 */
		public String getIdMember() {
			return idMember;
		}

		/**
		 * Sets the id member.
		 *
		 * @param idMember the new id member
		 */
		public void setIdMember(String idMember) {
			this.idMember = idMember;
		}
	}
	
	/**
	 * The Class Label.
	 *
	 * @author joel
	 */
	public class Label {
		
		/** The color. */
		private String color;
		
		/** The name. */
		private String name;
		
		/**
		 * Gets the color.
		 *
		 * @return the color
		 */
		public String getColor() {
			return color;
		}
		
		/**
		 * Sets the color.
		 *
		 * @param color the new color
		 */
		public void setColor(String color) {
			this.color = color;
		}
		
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
	}
}

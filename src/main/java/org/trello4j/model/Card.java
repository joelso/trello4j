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

	private String name;
	private String desc;
	private boolean closed;
	private Long idShort;
	private String idList;
	private String idBoard;
	private List<String> idMembers;
	private List<Attachment> attachments;
	private List<Label> labels;
	private String url;
	private Long pos;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public boolean isClosed() {
		return closed;
	}
	
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	
	public Long getIdShort() {
		return idShort;
	}
	
	public void setIdShort(Long idShort) {
		this.idShort = idShort;
	}
	
	public String getIdList() {
		return idList;
	}
	
	public void setIdList(String idList) {
		this.idList = idList;
	}
	
	public String getIdBoard() {
		return idBoard;
	}
	
	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}
	
	public List<String> getIdMembers() {
		return idMembers;
	}
	
	public void setIdMembers(List<String> idMembers) {
		this.idMembers = idMembers;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Long getPos() {
		return pos;
	}

	public void setPos(Long pos) {
		this.pos = pos;
	}
	
	public List<Attachment> getAttachments() {
		return attachments;
	}
	
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	public List<Label> getLabels() {
		return labels;
	}
	
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
		private String _id;
		private String bytes;
		private Date date;
		private String url;
		private String name;
		private String idMember;
		
		public String get_id() {
			return _id;
		}
		
		public void set_id(String _id) {
			this._id = _id;
		}
		
		public String getBytes() {
			return bytes;
		}
		
		public void setBytes(String bytes) {
			this.bytes = bytes;
		}
		
		public Date getDate() {
			return date;
		}
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		public String getUrl() {
			return url;
		}
		
		public void setUrl(String url) {
			this.url = url;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getIdMember() {
			return idMember;
		}

		public void setIdMember(String idMember) {
			this.idMember = idMember;
		}
	}
	
	/**
	 * 
	 * @author joel
	 *
	 */
	public class Label {
		private String color;
		private String name;
		
		public String getColor() {
			return color;
		}
		
		public void setColor(String color) {
			this.color = color;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}

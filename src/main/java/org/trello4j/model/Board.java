package org.trello4j.model;

/**
 * Model for a Trello Board
 * 
 * <code>
 * {
 * 	"id":"4d5ea62fd76aa1136000000c",
 * 	"name":"Trello Development",
 * 	"desc":"Trello board used by the Trello team to 
 * 			track work on Trello.  How meta!\n\nThe 
 * 			development of the Trello API is being 
 * 			tracked at https://trello.com/api\n\n
 * 			The development of Trello Mobile applications 
 * 			is being tracked at https://trello.com/mobile",
 * 	"closed":false,
 * 	"idOrganization":"4e1452614e4b8698470000e0",
 * 	"url":"https://trello.com/board/trello-development/4d5ea62fd76aa1136000000c",
 * 	"prefs":{
 * 		"voting":"public",
 * 		"permissionLevel":"public",
 * 		"invitations":"members",
 * 		"comments":"public"
 * 	}
 * }
 * </code>
 * @author joel
 *
 */
public class Board extends TrelloObject {
	
	// TODO: Write custom mapper to upper case 
	public enum PERMISSION_TYPE { PUBLIC, ORGANIZATION, MEMBERS }
	
	private String name;
	private String desc;
	private boolean closed;
	private String idOrganization;
	private String url;
	private Prefs prefs;
	
	
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
	
	public String getIdOrganization() {
		return idOrganization;
	}
	
	public void setIdOrganization(String idOrganization) {
		this.idOrganization = idOrganization;
	}
	
	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Prefs getPrefs() {
		return prefs;
	}
	
	public void setPrefs(Prefs prefs) {
		this.prefs = prefs;
	}
	

	public class Prefs {
		
		private PERMISSION_TYPE voting;
		private PERMISSION_TYPE permissionLevel;
		private PERMISSION_TYPE invitations;
		private PERMISSION_TYPE comments;
		
		public PERMISSION_TYPE getVoting() {
			return voting;
		}
		
		public void setVoting(PERMISSION_TYPE voting) {
			this.voting = voting;
		}
		
		public PERMISSION_TYPE getPermissionLevel() {
			return permissionLevel;
		}
		
		public void setPermissionLevel(PERMISSION_TYPE permissionLevel) {
			this.permissionLevel = permissionLevel;
		}
		
		public PERMISSION_TYPE getInvitations() {
			return invitations;
		}
		
		public void setInvitations(PERMISSION_TYPE invitations) {
			this.invitations = invitations;
		}
		
		public PERMISSION_TYPE getComments() {
			return comments;
		}

		public void setComments(PERMISSION_TYPE comments) {
			this.comments = comments;
		}
		
	}
}

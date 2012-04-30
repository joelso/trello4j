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
	
	// TODO: memberships
	// TODO: invitations
	
	/**
	 * The Enum PERMISSION_TYPE.
	 */
	public enum PERMISSION_TYPE { /** The PUBLIC. */
 PUBLIC, /** The ORGANIZATION. */
 ORGANIZATION, /** The MEMBERS. */
 MEMBERS }
	
	/** The name. */
	private String name;
	
	/** The desc. */
	private String desc;
	
	/** The closed. */
	private boolean closed;
	
	/** The invited. */
	private boolean invited = false;
	
	/** The id organization. */
	private String idOrganization;
	
	/** The url. */
	private String url;
	
	/** The prefs. */
	private Prefs prefs;
	
	
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
	 * Gets the id organization.
	 *
	 * @return the id organization
	 */
	public String getIdOrganization() {
		return idOrganization;
	}
	
	/**
	 * Sets the id organization.
	 *
	 * @param idOrganization the new id organization
	 */
	public void setIdOrganization(String idOrganization) {
		this.idOrganization = idOrganization;
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
	 * Gets the prefs.
	 *
	 * @return the prefs
	 */
	public Prefs getPrefs() {
		return prefs;
	}
	
	/**
	 * Sets the prefs.
	 *
	 * @param prefs the new prefs
	 */
	public void setPrefs(Prefs prefs) {
		this.prefs = prefs;
	}
	
	/**
	 * Checks if is invited.
	 *
	 * @return true, if is invited
	 */
	public boolean isInvited() {
		return invited;
	}
	
	/**
	 * Sets the invited.
	 *
	 * @param invited the new invited
	 */
	public void setInvited(boolean invited) {
		this.invited = invited;
	}

	/**
	 * The Class Prefs.
	 */
	public class Prefs {
		
		/** The voting. */
		private PERMISSION_TYPE voting;
		
		/** The permission level. */
		private PERMISSION_TYPE permissionLevel;
		
		/** The invitations. */
		private PERMISSION_TYPE invitations;
		
		/** The comments. */
		private PERMISSION_TYPE comments;
		
		/**
		 * Gets the voting.
		 *
		 * @return the voting
		 */
		public PERMISSION_TYPE getVoting() {
			return voting;
		}
		
		/**
		 * Sets the voting.
		 *
		 * @param voting the new voting
		 */
		public void setVoting(PERMISSION_TYPE voting) {
			this.voting = voting;
		}
		
		/**
		 * Gets the permission level.
		 *
		 * @return the permission level
		 */
		public PERMISSION_TYPE getPermissionLevel() {
			return permissionLevel;
		}
		
		/**
		 * Sets the permission level.
		 *
		 * @param permissionLevel the new permission level
		 */
		public void setPermissionLevel(PERMISSION_TYPE permissionLevel) {
			this.permissionLevel = permissionLevel;
		}
		
		/**
		 * Gets the invitations.
		 *
		 * @return the invitations
		 */
		public PERMISSION_TYPE getInvitations() {
			return invitations;
		}
		
		/**
		 * Sets the invitations.
		 *
		 * @param invitations the new invitations
		 */
		public void setInvitations(PERMISSION_TYPE invitations) {
			this.invitations = invitations;
		}
		
		/**
		 * Gets the comments.
		 *
		 * @return the comments
		 */
		public PERMISSION_TYPE getComments() {
			return comments;
		}

		/**
		 * Sets the comments.
		 *
		 * @param comments the new comments
		 */
		public void setComments(PERMISSION_TYPE comments) {
			this.comments = comments;
		}
		
	}
}

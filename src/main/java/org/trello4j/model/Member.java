package org.trello4j.model;

import java.util.List;


/**
 * <code>
 * {
 * 	"id":"4e918355e52581aa44eb0754",
 * 	"avatarHash":"8880c87b91499ae0c4051bd1c7bcc4a7",
 * 	"fullName":"Joel Söderström",
 * 	"initials":"JS",
 * 	"status":"disconnected",
 * 	"url":"https://trello.com/joelsoderstrom",
 * 	"username":"joelsoderstrom",
 * 	"idOrganizations":[],
 * 	"idBoards":[]
 * }
 * </code>
 * 
 * @author joel
 *
 */
public class Member extends TrelloObject {
	
	/**
	 * The Enum STATUS.
	 */
	public enum STATUS { /** The disconnected. */
 disconnected, /** The active. */
 active, /** The idle. */
 idle }
	
	/** The avatar hash. */
	private String avatarHash;
	
	/** The full name. */
	private String fullName;
	
	/** The initials. */
	private String initials;
	
	/** The status. */
	private STATUS status;
	
	/** The url. */
	private String url;
	
	/** The username. */
	private String username;
	
	/** The id organizations. */
	private List<String> idOrganizations;
	
	/** The id boards. */
	private List<String> idBoards;
	
	/**
	 * Gets the avatar hash.
	 *
	 * @return the avatar hash
	 */
	public String getAvatarHash() {
		return avatarHash;
	}
	
	/**
	 * Sets the avatar hash.
	 *
	 * @param avatarHash the new avatar hash
	 */
	public void setAvatarHash(String avatarHash) {
		this.avatarHash = avatarHash;
	}
	
	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * Gets the initials.
	 *
	 * @return the initials
	 */
	public String getInitials() {
		return initials;
	}
	
	/**
	 * Sets the initials.
	 *
	 * @param initials the new initials
	 */
	public void setInitials(String initials) {
		this.initials = initials;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public STATUS getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(STATUS status) {
		this.status = status;
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
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the id organizations.
	 *
	 * @return the id organizations
	 */
	public List<String> getIdOrganizations() {
		return idOrganizations;
	}
	
	/**
	 * Sets the id organizations.
	 *
	 * @param idOrganizations the new id organizations
	 */
	public void setIdOrganizations(List<String> idOrganizations) {
		this.idOrganizations = idOrganizations;
	}
	
	/**
	 * Gets the id boards.
	 *
	 * @return the id boards
	 */
	public List<String> getIdBoards() {
		return idBoards;
	}
	
	/**
	 * Sets the id boards.
	 *
	 * @param idBoards the new id boards
	 */
	public void setIdBoards(List<String> idBoards) {
		this.idBoards = idBoards;
	}
	
}

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

	public enum Status {
		disconnected,
		active,
		idle
	}

	private String avatarHash;

	private String fullName;

	private String initials;

	private Status status;

	private String url;

	private String username;

	private List<String> idOrganizations;

	private List<String> idBoards;


    public String getAvatarHash() {
		return avatarHash;
	}

	public void setAvatarHash(String avatarHash) {
		this.avatarHash = avatarHash;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getIdOrganizations() {
		return idOrganizations;
	}

	public void setIdOrganizations(List<String> idOrganizations) {
		this.idOrganizations = idOrganizations;
	}

	public List<String> getIdBoards() {
		return idBoards;
	}

	public void setIdBoards(List<String> idBoards) {
		this.idBoards = idBoards;
	}

}

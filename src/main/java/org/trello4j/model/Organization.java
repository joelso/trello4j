package org.trello4j.model;

/**
 * <code>
 * {
 * 	"id":"4eb3f3f1e679eb839b4c594b",
 * 	"name":"frostdigital",
 * 	"displayName":"Frost Digital",
 * 	"desc":"",
 * 	"url":"https://trello.com/frostdigital",
 * 	"website":"http://frostdigital.se"
 * }
 * </code>
 * 
 * @author joel
 * 
 */
public class Organization extends TrelloObject {

	private String name;
	private String displayName;
	private String desc;
	private String website;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

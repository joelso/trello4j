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

	/** The name. */
	private String name;
	
	/** The display name. */
	private String displayName;
	
	/** The desc. */
	private String desc;
	
	/** The website. */
	private String website;
	
	/** The url. */
	private String url;
	
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
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
	 * Gets the website.
	 *
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Sets the website.
	 *
	 * @param website the new website
	 */
	public void setWebsite(String website) {
		this.website = website;
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
	
}

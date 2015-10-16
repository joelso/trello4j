package org.trello4j.model;

import java.util.Date;
import java.util.List;


public class Webhook extends TrelloObject {

	private String desc;
    
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}


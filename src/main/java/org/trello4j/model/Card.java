package org.trello4j.model;

import java.util.List;


/**
 * <code>
 * {
 * 	"id":"4f7faaef0a3adabc77367b22",
 * 	"name":"(16) Hitchhiker’s Guide to iOS Development",
 * 	"desc":"",
 * 	"closed":false,
 * 	"idShort":9,
 * 	"idList":"4f2c146bb13c636b3f236634",
 * 	"idBoard":"4f2c146bb13c636b3f236630",
 * 	"idMembers":["4e9e99013b688d8d2e079405"],
 * 	"url":"https://trello.com/card/16-hitchhiker-s-guide-to-ios-development/4f2c146bb13c636b3f236630/9",
 * 	"attachments":[],
 * 	"labels":[],
 * 	"badges":{
 * 		"votes":0,
 * 		"viewingMemberVoted":false,
 * 		"fogbugz":"",
 * 		"checkItems":0,
 * 		"checkItemsChecked":0,
 * 		"comments":0,
 * 		"attachments":0,
 * 		"description":false,
 * 		"due":null
 * 		},
 * 	"pos":65536,
 * 	"idChecklists":[],
 * 	"checkItemStates":[]
 * }
 * </code>
 * 
 * @author joel
 *
 */
public class Card extends TrelloObject {
	
	// TODO: attachments
	// TODO: labels
	// TODO: idChecklists
	// TODO: checkItemStates

	private String name;
	private String desc;
	private boolean closed;
	private Long idShort;
	private String idList;
	private String idBoard;
	private List<String> idMembers;
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
	
}

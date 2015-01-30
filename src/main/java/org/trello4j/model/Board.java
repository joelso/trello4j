package org.trello4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.trello4j.gson.CopyOfPermissionTypeDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Board extends TrelloObject {

	@JsonDeserialize(using = CopyOfPermissionTypeDeserializer.class)
	public enum PERMISSION_TYPE {
		PUBLIC, ORGANIZATION, MEMBERS
	}

	private String name;
	private String desc;
	private boolean closed;
	private boolean invited = false;
	private String idOrganization;
	private String url;
	private Prefs prefs;
	private boolean pinned;
	private LabelNames labelNames;

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

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

	public LabelNames getLabelNames() {
		return labelNames;
	}

	public void setLabelNames(LabelNames labelNames) {
		this.labelNames = labelNames;
	}

	public boolean isInvited() {
		return invited;
	}

	public void setInvited(boolean invited) {
		this.invited = invited;
	}

	public class LabelNames {

		private String yellow;
		private String red;
		private String purple;
		private String orange;
		private String green;
		private String blue;

		public String getYellow() {
			return yellow;
		}

		public void setYellow(String yellow) {
			this.yellow = yellow;
		}

		public String getRed() {
			return red;
		}

		public void setRed(String red) {
			this.red = red;
		}

		public String getPurple() {
			return purple;
		}

		public void setPurple(String purple) {
			this.purple = purple;
		}

		public String getOrange() {
			return orange;
		}

		public void setOrange(String orange) {
			this.orange = orange;
		}

		public String getGreen() {
			return green;
		}

		public void setGreen(String green) {
			this.green = green;
		}

		public String getBlue() {
			return blue;
		}

		public void setBlue(String blue) {
			this.blue = blue;
		}

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Prefs {

		private PERMISSION_TYPE voting;
		private PERMISSION_TYPE permissionLevel;
		private PERMISSION_TYPE invitations;
		private PERMISSION_TYPE comments;
		private boolean selfJoin;
		private boolean cardCovers;
		private boolean canBePublic;
		private boolean canBeOrg;
		private boolean canBePrivate;
		private boolean canInvite;

		public boolean isSelfJoin() {
			return selfJoin;
		}

		public void setSelfJoin(boolean selfJoin) {
			this.selfJoin = selfJoin;
		}

		public boolean isCardCovers() {
			return cardCovers;
		}

		public void setCardCovers(boolean cardCovers) {
			this.cardCovers = cardCovers;
		}

		public boolean isCanBePublic() {
			return canBePublic;
		}

		public void setCanBePublic(boolean canBePublic) {
			this.canBePublic = canBePublic;
		}

		public boolean isCanBeOrg() {
			return canBeOrg;
		}

		public void setCanBeOrg(boolean canBeOrg) {
			this.canBeOrg = canBeOrg;
		}

		public boolean isCanBePrivate() {
			return canBePrivate;
		}

		public void setCanBePrivate(boolean canBePrivate) {
			this.canBePrivate = canBePrivate;
		}

		public boolean isCanInvite() {
			return canInvite;
		}

		public void setCanInvite(boolean canInvite) {
			this.canInvite = canInvite;
		}

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

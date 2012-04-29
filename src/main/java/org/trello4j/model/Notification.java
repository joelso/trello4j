package org.trello4j.model;

/**
 * <code>
 * {
 *     "id": "4f82edfd34862b8473d92a8a",
 *     "unread": false,
 *     "type": "addedToCard",
 *     "date": "2012-04-09T14:11:09.416Z",
 *     "data": {
 *         "card": {
 *             "name": "Test card",
 *             "id": "4f82ed8297d499ab4149a581"
 *         },
 *         "board": {
 *             "name": "Trello4j Testing",
 *             "id": "4f82ed4f1903bae43e66f5f9"
 *         }
 *     },
 *     "idMemberCreator": "4e918355e52581aa44eb0754",
 *     "memberCreator": {
 *         "id": "4e918355e52581aa44eb0754",
 *         "username": "joelsoderstrom",
 *         "fullName": "Joel Söderström",
 *         "initials": "JS",
 *         "avatarHash": "8880c87b91499ae0c4051bd1c7bcc4a7"
 *     }
 * }
 * </code>
 * 
 * @author joel
 * 
 */
public class Notification extends Action {

	/** The unread. */
	private boolean unread;

	/**
	 * Checks if is unread.
	 * 
	 * @return true, if is unread
	 */
	public boolean isUnread() {
		return unread;
	}

	/**
	 * Sets the unread.
	 * 
	 * @param unread
	 *            the new unread
	 */
	public void setUnread(boolean unread) {
		this.unread = unread;
	}
}

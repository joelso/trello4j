package org.trello4j;

import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.List;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;

/**
 * To be implemented:
 * <ul>
 * <li>GET /1/notifications/[notification_id]</li>
 * <li>GET /1/notifications/[notification_id]/[field]</li>
 * <li>GET /1/notifications/[notification_id]/board</li>
 * <li>GET /1/notifications/[notification_id]/board/[field]</li>
 * <li>GET /1/notifications/[notification_id]/card</li>
 * <li>GET /1/notifications/[notification_id]/card/[field]</li>
 * <li>GET /1/notifications/[notification_id]/list</li>
 * <li>GET /1/notifications/[notification_id]/list/[field]</li>
 * <li>GET /1/notifications/[notification_id]/member</li>
 * <li>GET /1/notifications/[notification_id]/member/[field]</li>
 * <li>GET /1/notifications/[notification_id]/memberCreator</li>
 * <li>GET /1/notifications/[notification_id]/memberCreator/[field]</li>
 * <li>GET /1/notifications/[notification_id]/organization</li>
 * <li>GET /1/notifications/[notification_id]/organization/[field]</li>
 * </ul>
 * .
 * 
 * @author joel
 */
public interface NotificationService {

	/**
	 * Gets the notification.
	 * 
	 * @param notificationId
	 *            the notification id
	 * @return the notification
	 */
	Notification getNotification(String notificationId, String... filter);

	/**
	 * Gets the board by notification.
	 * 
	 * @param notificationId
	 *            the notification id
	 * @return the board by notification
	 */
	Board getBoardByNotification(String notificationId, String... filter);

	/**
	 * Gets the card by notification.
	 * 
	 * @param notificationId
	 *            the notification id
	 * @return the card by notification
	 */
	Card getCardByNotification(String notificationId, String... filter);

	/**
	 * Gets the list by notification.
	 * 
	 * @param notificationId
	 *            the notification id
	 * @return the list by notification
	 */
	List getListByNotification(String notificationId, String... filter);

	/**
	 * Gets the member by notification.
	 * 
	 * @param notificationId
	 *            the notification id
	 * @return the member by notification
	 */
	Member getMemberByNotification(String notificationId, String... filter);

	/**
	 * Gets the member creator by notification.
	 * 
	 * @param notificationId
	 *            the notification id
	 * @return the member creator by notification
	 */
	Member getMemberCreatorByNotification(String notificationId,
			String... filter);

	/**
	 * Gets the organization creator by notification.
	 * 
	 * @param notificationId
	 *            the notification id
	 * @return the organization creator by notification
	 */
	Member getOrganizationCreatorByNotification(String notificationId,
			String... filter);
}
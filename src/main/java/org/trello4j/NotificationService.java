package org.trello4j;

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
 * 
 * @author joel
 * 
 */
public interface NotificationService {

	Notification getNotification(String notificationId);
		
}
package org.trello4j.core;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURL;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;

import com.google.gson.reflect.TypeToken;

public class DefaultNotificationOperations extends AbstractOperations implements NotificationOperations {

	public DefaultNotificationOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Notification getNotification(String notificationId, final String... filter) {
		validateObjectId(notificationId);

		final String url = TrelloURL.create(apiKey, TrelloURL.NOTIFICATION_URL, notificationId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Notification>() {
		}, doGet(url));
	}

	@Override
	public Board getBoardByNotification(String notificationId, final String... filter) {
		validateObjectId(notificationId);

		final String url = TrelloURL.create(apiKey, TrelloURL.NOTIFICATION_BOARDS_URL, notificationId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doGet(url));
	}

	@Override
	public Card getCardByNotification(String notificationId, final String... filter) {
		validateObjectId(notificationId);

		final String url = TrelloURL.create(apiKey, TrelloURL.NOTIFICATION_CARDS_URL, notificationId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Card>() {
		}, doGet(url));
	}

	@Override
	public org.trello4j.model.List getListByNotification(String notificationId, final String... filter) {
		validateObjectId(notificationId);

		final String url = TrelloURL.create(apiKey, TrelloURL.NOTIFICATION_LIST_URL, notificationId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<org.trello4j.model.List>() {
		}, doGet(url));
	}

	@Override
	public Member getMemberByNotification(String notificationId, final String... filter) {
		validateObjectId(notificationId);

		final String url = TrelloURL.create(apiKey, TrelloURL.NOTIFICATION_MEMBERS_URL, notificationId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doGet(url));
	}

	@Override
	public Member getMemberCreatorByNotification(String notificationId, final String... filter) {
		validateObjectId(notificationId);

		final String url = TrelloURL.create(apiKey, TrelloURL.NOTIFICATION_MEMBER_CREATOR_URL, notificationId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doGet(url));
	}

	@Override
	public Member getOrganizationCreatorByNotification(String notificationId, final String... filter) {
		validateObjectId(notificationId);

		final String url = TrelloURL.create(apiKey, TrelloURL.NOTIFICATION_ORGANIZATION_URL, notificationId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doGet(url));
	}

}
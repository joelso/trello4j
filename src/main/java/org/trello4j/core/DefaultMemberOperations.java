package org.trello4j.core;

import java.util.List;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURL;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;
import org.trello4j.model.Organization;

import com.google.gson.reflect.TypeToken;

public class DefaultMemberOperations extends AbstractOperations implements MemberOperations {

	public DefaultMemberOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Member getMember(String usernameOrId, final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.MEMBER_URL, usernameOrId).token(token).filter(filter).build();
		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doGet(url));
	}

	@Override
	public List<Board> getBoardsByMember(String usernameOrId, final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.MEMBER_BOARDS_URL, usernameOrId).token(token).filter(filter).build();
		return trelloObjFactory.createObject(new TypeToken<List<Board>>() {
		}, doGet(url));
	}

	@Override
	public List<Action> getActionsByMember(String usernameOrId) {

		final String url = TrelloURL.create(apiKey, TrelloURL.MEMBER_ACTIONS_URL, usernameOrId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<List<Action>>() {
		}, doGet(url));
	}

	@Override
	public List<Card> getCardsByMember(String usernameOrId, final String... filter) {

		final String url = TrelloURL.create(apiKey, TrelloURL.MEMBER_CARDS_URL, usernameOrId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Card>>() {
		}, doGet(url));
	}

	@Override
	public List<Notification> getNotificationsByMember(String usernameOrId, final String... filter) {

		final String url = TrelloURL.create(apiKey, TrelloURL.MEMBER_NOTIFIACTIONS_URL, usernameOrId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Notification>>() {
		}, doGet(url));
	}

	@Override
	public List<Organization> getOrganizationsByMember(String usernameOrId, final String... filter) {

		final String url = TrelloURL.create(apiKey, TrelloURL.MEMBER_ORGANIZATION_URL, usernameOrId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Organization>>() {
		}, doGet(url));
	}

	@Override
	public List<Organization> getOrganizationsInvitedByMember(String usernameOrId, final String... filter) {

		final String url = TrelloURL.create(apiKey, TrelloURL.MEMBER_ORGANIZATION_INVITED_URL, usernameOrId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Organization>>() {
		}, doGet(url));
	}

}

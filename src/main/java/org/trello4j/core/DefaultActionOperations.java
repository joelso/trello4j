package org.trello4j.core;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURL;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

import com.google.gson.reflect.TypeToken;

public class DefaultActionOperations extends AbstractOperations implements ActionOperations {

	private String actionId;

	DefaultActionOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory, String actionId) {
		super(apiKey, token, trelloObjFactory);
		validateObjectId(actionId);
		this.actionId = actionId;
	}

	@Override
	public Action get(final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ACTION_URL, actionId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Action>() {
		}, doGet(url));
	}

	@Override
	public Board getBoard(final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ACTION_BOARD_URL, actionId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doGet(url));
	}

	@Override
	public Card getCard(final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ACTION_CARD_URL, actionId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Card>() {
		}, doGet(url));
	}

	@Override
	public Member getMember(final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ACTION_MEMBER_URL, actionId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doGet(url));
	}

	@Override
	public org.trello4j.model.List getList(final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ACTION_LIST_URL, actionId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<org.trello4j.model.List>() {
		}, doGet(url));
	}

	@Override
	public Member getMemberCreator(final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ACTION_MEMBERCREATOR_URL, actionId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doGet(url));
	}

	@Override
	public Organization getOrganization(final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ACTION_ORGANIZATION_URL, actionId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<Organization>() {
		}, doGet(url));
	}

}

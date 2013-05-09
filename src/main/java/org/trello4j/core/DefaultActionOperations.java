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

	DefaultActionOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
	}

	@Override
	public Action getAction(final String actionId, final String... filter) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_URL, actionId)
				.token(token)
				.filter(filter)
				.build();

		return trelloObjFactory.createObject(new TypeToken<Action>() {
		}, doGet(url));
	}

	public Board getBoardByAction(String actionId, final String... filter) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_BOARD_URL, actionId)
				.token(token)
				.filter(filter)
				.build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doGet(url));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.trello4j.ActionService#getCardByAction(java.lang.String)
	 */
	@Override
	public Card getCardByAction(String actionId, final String... filter) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_CARD_URL, actionId)
				.token(token)
				.filter(filter)
				.build();

		return trelloObjFactory.createObject(new TypeToken<Card>() {
		}, doGet(url));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.trello4j.ActionService#getMemberByAction(java.lang.String)
	 */
	@Override
	public Member getMemberByAction(String actionId, final String... filter) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_MEMBER_URL, actionId)
				.token(token)
				.filter(filter)
				.build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doGet(url));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.trello4j.ActionService#getListByAction(java.lang.String)
	 */
	@Override
	public org.trello4j.model.List getListByAction(String actionId,
			final String... filter) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_LIST_URL, actionId)
				.token(token)
				.filter(filter)
				.build();

		return trelloObjFactory.createObject(
				new TypeToken<org.trello4j.model.List>() {
				},
				doGet(url));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.trello4j.ActionService#getMemberCreatorByAction(java.lang.String)
	 */
	@Override
	public Member getMemberCreatorByAction(String actionId,
			final String... filter) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_MEMBERCREATOR_URL, actionId)
				.token(token)
				.filter(filter)
				.build();

		return trelloObjFactory.createObject(new TypeToken<Member>() {
		}, doGet(url));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.trello4j.ActionService#getOrganizationByAction(java.lang.String)
	 */
	@Override
	public Organization getOrganizationByAction(String actionId,
			final String... filter) {
		validateObjectId(actionId);

		final String url = TrelloURL
				.create(apiKey, TrelloURL.ACTION_ORGANIZATION_URL, actionId)
				.token(token)
				.filter(filter)
				.build();

		return trelloObjFactory.createObject(new TypeToken<Organization>() {
		}, doGet(url));
	}

}

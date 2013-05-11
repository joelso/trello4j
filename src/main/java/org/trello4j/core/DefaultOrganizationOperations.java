package org.trello4j.core;

import java.util.List;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURL;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

import com.google.gson.reflect.TypeToken;

public class DefaultOrganizationOperations extends AbstractOperations implements OrganizationOperations {

	public DefaultOrganizationOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
	}

	@Override
	public Organization getOrganization(String organizationName, final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ORGANIZATION_URL, organizationName).token(token).filter(filter).build();
		return trelloObjFactory.createObject(new TypeToken<Organization>() {
		}, doGet(url));
	}

	@Override
	public List<Board> getBoardsByOrganization(String organizationName, final String... filter) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ORGANIZATION_BOARDS_URL, organizationName).token(token).filter(filter).build();
		return trelloObjFactory.createObject(new TypeToken<List<Board>>() {
		}, doGet(url));
	}

	@Override
	public List<Action> getActionsByOrganization(String organizationNameOrId) {
		final String url = TrelloURL.create(apiKey, TrelloURL.ORGANIZATION_ACTIONS_URL, organizationNameOrId).token(token).build();
		return trelloObjFactory.createObject(new TypeToken<List<Action>>() {
		}, doGet(url));
	}

	@Override
	public List<Member> getMembersByOrganization(String organizationNameOrId, final String... filter) {

		final String url = TrelloURL.create(apiKey, TrelloURL.ORGANIZATION_MEMBERS_URL, organizationNameOrId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doGet(url));
	}

}

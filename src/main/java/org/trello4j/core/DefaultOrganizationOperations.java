package org.trello4j.core;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.trello4j.TrelloURI;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

public class DefaultOrganizationOperations extends AbstractOperations implements OrganizationOperations {

	private final String organizationNameOrId;

	public DefaultOrganizationOperations(String organizationNameOrId, TrelloAccessor trelloAccessor) {
		super(trelloAccessor);
		this.organizationNameOrId = organizationNameOrId;
	}

	@Override
	public Organization get(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ORGANIZATION_URL, organizationNameOrId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Organization.class);
	}

	@Override
	public List<Board> getBoards(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ORGANIZATION_BOARDS_URL, organizationNameOrId).filter(filters);
		ParameterizedTypeReference<List<Board>> typeReference = new ParameterizedTypeReference<List<Board>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Action> getActions() {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ORGANIZATION_ACTIONS_URL, organizationNameOrId);
		ParameterizedTypeReference<List<Action>> typeReference = new ParameterizedTypeReference<List<Action>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Member> getMembers(final String... filter) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.ORGANIZATION_MEMBERS_URL, organizationNameOrId);
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}
}

package org.trello4j.core;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.trello4j.TrelloURI;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;
import org.trello4j.model.Organization;

public class DefaultMemberOperations extends AbstractOperations implements MemberOperations {

	private String usernameOrId;

	DefaultMemberOperations(String usernameOrId, TrelloAccessor trelloAccessor) {
		super(trelloAccessor);
		validateNotNull(usernameOrId);
		this.usernameOrId = usernameOrId;
	}

	@Override
	public Member get(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.MEMBER_URL, usernameOrId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Member.class);
	}

	@Override
	public List<Board> getBoards(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.MEMBER_BOARDS_URL, usernameOrId).filter(filters);
		ParameterizedTypeReference<List<Board>> typeReference = new ParameterizedTypeReference<List<Board>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Action> getActions() {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.MEMBER_ACTIONS_URL, usernameOrId);
		ParameterizedTypeReference<List<Action>> typeReference = new ParameterizedTypeReference<List<Action>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Card> getCards(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.MEMBER_CARDS_URL, usernameOrId).filter(filters);
		ParameterizedTypeReference<List<Card>> typeReference = new ParameterizedTypeReference<List<Card>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Notification> getNotifications(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.MEMBER_NOTIFIACTIONS_URL, usernameOrId).filter(filters);
		ParameterizedTypeReference<List<Notification>> typeReference = new ParameterizedTypeReference<List<Notification>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Organization> getOrganizations(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.MEMBER_ORGANIZATION_URL, usernameOrId).filter(filters);
		ParameterizedTypeReference<List<Organization>> typeReference = new ParameterizedTypeReference<List<Organization>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Organization> getInvitedOrganizations(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.MEMBER_ORGANIZATION_INVITED_URL, usernameOrId).filter(filters);
		ParameterizedTypeReference<List<Organization>> typeReference = new ParameterizedTypeReference<List<Organization>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

}

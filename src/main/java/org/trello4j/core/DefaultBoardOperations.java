package org.trello4j.core;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.trello4j.TrelloURI;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Board.Prefs;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

public class DefaultBoardOperations extends AbstractOperations implements BoardOperations {

	private final String boardId;

	DefaultBoardOperations(String boardId, TrelloAccessor trelloAccessor) {
		super(trelloAccessor);
		validateObjectId(boardId);
		this.boardId = boardId;
	}

	@Override
	public Board get() {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.BOARD_URL, boardId);
		return getTrelloAccessor().doGet(uri.build(), Board.class);
	}

	@Override
	public List<Action> getActions(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.BOARD_ACTIONS_URL, boardId).filter(filters);
		ParameterizedTypeReference<List<Action>> typeReference = new ParameterizedTypeReference<List<Action>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Card> getCards(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.BOARD_CARDS_URL, boardId).filter(filters);
		ParameterizedTypeReference<List<Card>> typeReference = new ParameterizedTypeReference<List<Card>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Checklist> getChecklist() {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.BOARD_CHECKLISTS_URL, boardId);
		ParameterizedTypeReference<List<Checklist>> typeReference = new ParameterizedTypeReference<List<Checklist>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<org.trello4j.model.List> getList(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.BOARD_LISTS_URL, boardId).filter(filters);
		ParameterizedTypeReference<List<org.trello4j.model.List>> typeReference = new ParameterizedTypeReference<List<org.trello4j.model.List>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Member> getMembers(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.BOARD_MEMBERS_URL, boardId).filter(filters);
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public List<Member> getInvitedMembers(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.BOARD_MEMBERS_INVITED_URL, boardId).filter(filters);
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doGet(uri.build(), typeReference);
	}

	@Override
	public Prefs getPrefs() {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.BOARD_PREFS_URL, boardId);
		return getTrelloAccessor().doGet(uri.build(), Prefs.class);
	}

	@Override
	public Organization getOrganization(final String... filters) {
		TrelloURI uri = getTrelloAccessor().createTrelloUri(TrelloURI.BOARD_ORGANIZAION_URL, boardId).filter(filters);
		return getTrelloAccessor().doGet(uri.build(), Organization.class);
	}

}

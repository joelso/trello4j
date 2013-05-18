package org.trello4j.core;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.trello4j.TrelloURL;
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
		return getTrelloAccessor().doGet(Board.class, TrelloURL.BOARD_URL, boardId);
	}

	@Override
	public List<Action> getActions(final String... filters) {
		ParameterizedTypeReference<List<Action>> typeReference = new ParameterizedTypeReference<List<Action>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.BOARD_ACTIONS_URL, boardId, filters);
	}

	@Override
	public List<Card> getCards(final String... filters) {
		ParameterizedTypeReference<List<Card>> typeReference = new ParameterizedTypeReference<List<Card>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.BOARD_CARDS_URL, boardId, filters);
	}

	@Override
	public List<Checklist> getChecklist() {
		ParameterizedTypeReference<List<Checklist>> typeReference = new ParameterizedTypeReference<List<Checklist>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.BOARD_CHECKLISTS_URL, boardId);
	}

	@Override
	public List<org.trello4j.model.List> getList(final String... filters) {
		ParameterizedTypeReference<List<org.trello4j.model.List>> typeReference = new ParameterizedTypeReference<List<org.trello4j.model.List>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.BOARD_LISTS_URL, boardId, filters);
	}

	@Override
	public List<Member> getMembers(final String... filters) {
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.BOARD_MEMBERS_URL, boardId, filters);
	}

	@Override
	public List<Member> getInvitedMembers(final String... filters) {
		ParameterizedTypeReference<List<Member>> typeReference = new ParameterizedTypeReference<List<Member>>() {
		};
		return getTrelloAccessor().doGet(typeReference, TrelloURL.BOARD_MEMBERS_INVITED_URL, boardId, filters);
	}

	@Override
	public Prefs getPrefs() {
		return getTrelloAccessor().doGet(Prefs.class, TrelloURL.BOARD_PREFS_URL, boardId);
	}

	@Override
	public Organization getOrganization(final String... filters) {
		validateObjectId(boardId);
		return getTrelloAccessor().doGet(Organization.class, TrelloURL.BOARD_ORGANIZAION_URL, boardId, filters);
	}

}

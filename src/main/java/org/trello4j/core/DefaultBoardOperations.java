package org.trello4j.core;

import java.util.List;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloURL;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Board.Prefs;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

import com.google.gson.reflect.TypeToken;

public class DefaultBoardOperations extends AbstractOperations implements BoardOperations {

	DefaultBoardOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		super(apiKey, token, trelloObjFactory);
	}

	@Override
	public Board getBoard(final String boardId) {
		validateObjectId(boardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.BOARD_URL, boardId).token(token).build();

		return trelloObjFactory.createObject(new TypeToken<Board>() {
		}, doGet(url));
	}

	@Override
	public List<Action> getActionsByBoard(final String boardId, final String... filter) {
		validateObjectId(boardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.BOARD_ACTIONS_URL, boardId).token(token).filter(filter).build();

		return trelloObjFactory.createObject(new TypeToken<List<Action>>() {
		}, doGet(url));
	}

	@Override
	public List<Card> getCardsByBoard(String boardId, final String... filter) {
		validateObjectId(boardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.BOARD_CARDS_URL, boardId).token(token).filter(filter).build();
		return trelloObjFactory.createObject(new TypeToken<List<Card>>() {
		}, doGet(url));
	}

	@Override
	public List<Checklist> getChecklistByBoard(String boardId) {
		validateObjectId(boardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.BOARD_CHECKLISTS_URL, boardId).token(token).build();
		return trelloObjFactory.createObject(new TypeToken<List<Checklist>>() {
		}, doGet(url));
	}

	@Override
	public List<org.trello4j.model.List> getListByBoard(String boardId, final String... filter) {
		validateObjectId(boardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.BOARD_LISTS_URL, boardId).token(token).filter(filter).build();
		return trelloObjFactory.createObject(new TypeToken<List<org.trello4j.model.List>>() {
		}, doGet(url));
	}

	@Override
	public List<Member> getMembersByBoard(String boardId, final String... filter) {
		validateObjectId(boardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.BOARD_MEMBERS_URL, boardId).token(token).filter(filter).build();
		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doGet(url));
	}

	@Override
	public List<Member> getMembersInvitedByBoard(String boardId, final String... filter) {
		validateObjectId(boardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.BOARD_MEMBERS_INVITED_URL, boardId).token(token).filter(filter).build();
		return trelloObjFactory.createObject(new TypeToken<List<Member>>() {
		}, doGet(url));
	}

	@Override
	public Prefs getPrefsByBoard(String boardId) {
		validateObjectId(boardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.BOARD_PREFS_URL, boardId).token(token).build();
		return trelloObjFactory.createObject(new TypeToken<Prefs>() {
		}, doGet(url));
	}

	@Override
	public Organization getOrganizationByBoard(String boardId, final String... filter) {
		validateObjectId(boardId);

		final String url = TrelloURL.create(apiKey, TrelloURL.BOARD_ORGANIZAION_URL, boardId).token(token).filter(filter).build();
		return trelloObjFactory.createObject(new TypeToken<Organization>() {
		}, doGet(url));
	}

}

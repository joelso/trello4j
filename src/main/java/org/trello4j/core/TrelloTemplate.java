package org.trello4j.core;

import org.trello4j.TrelloOperations;
import org.trello4j.TrelloURI;
import org.trello4j.model.Type;

public class TrelloTemplate extends TrelloAccessor implements TrelloOperations {

	public TrelloTemplate(String apiKey) {
		this(apiKey, null);
	}

	public TrelloTemplate(String apiKey, String accessToken) {
		super(apiKey, accessToken);
	}

	@Override
	public ActionOperations boundActionOperations(String actionId) {
		return new DefaultActionOperations(actionId, this);
	}

	@Override
	public OrganizationOperations boundOrganizationOperations(String organizationNameOrId) {
		return new DefaultOrganizationOperations(organizationNameOrId, this);
	}

	@Override
	public ListOperations boundListOperations(String listId) {
		return new DefaultListOperations(listId, this);
	}

	@Override
	public ChecklistOperations boundChecklistOperations(String checklistId) {
		return new DefaultChecklistOperations(checklistId, this);
	}

	@Override
	public MemberOperations boundMemberOperations(String usernameOrId) {
		return new DefaultMemberOperations(usernameOrId, this);
	}

	@Override
	public BoardOperations boundBoardOperations(String boardId) {
		return new DefaultBoardOperations(boardId, this);
	}

	@Override
	public NotificationOperations boundNotificationOperations(String notificationId) {
		return new DefaultNotificationOperations(notificationId, this);
	}

	@Override
	public CardOperations boundCardOperations(String cardId) {
		return new DefaultCardOperations(cardId, this);
	}

	@Override
	public TokenOperations boundTokenOperations(String tokenId) {
		return new DefaultTokenOperations(tokenId, this);
	}

	public Type getType(String idOrName) {
		TrelloURI uri = createTrelloUri(TrelloURI.TYPE_URL, idOrName);
		return doGet(uri.build(), Type.class);
	}
}

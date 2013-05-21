package org.trello4j.core;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloOperations;

/**
 * The Class TrelloImpl.
 */
public class TrelloTemplate extends TrelloAccessor implements TrelloOperations {

	private final OrganizationOperations organizationOperations;
	private final NotificationOperations notificationOperations;
	private final TokenOperations tokenOperations;
	private final TypeOperations typeOperations;
	private final TrelloObjectFactoryImpl trelloObjFactory;

	public TrelloTemplate(String apiKey) {
		this(apiKey, null);
	}

	public TrelloTemplate(String apiKey, String accessToken) {
		super(apiKey, accessToken);

		trelloObjFactory = new TrelloObjectFactoryImpl();

		organizationOperations = new DefaultOrganizationOperations(apiKey, accessToken, trelloObjFactory);
		notificationOperations = new DefaultNotificationOperations(apiKey, accessToken, trelloObjFactory);
		tokenOperations = new DefaultTokenOperations(apiKey, accessToken, trelloObjFactory);
		typeOperations = new DefaultTypeOperations(apiKey, accessToken, trelloObjFactory);
	}

	@Override
	public ActionOperations boundActionOperations(String actionId) {
		return new DefaultActionOperations(actionId, this);
	}

	@Override
	public OrganizationOperations getOrganizationOperations() {
		return organizationOperations;
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
	public NotificationOperations getNotificationOperations() {
		return notificationOperations;
	}

	@Override
	public CardOperations boundCardOperations(String cardId) {
		return new DefaultCardOperations(cardId, this);
	}

	@Override
	public TokenOperations getTokenOperations() {
		return tokenOperations;
	}

	@Override
	public TypeOperations getTypeOperations() {
		return typeOperations;
	}
}

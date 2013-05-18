package org.trello4j.core;

import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloOperations;

/**
 * The Class TrelloImpl.
 */
public class TrelloTemplate extends TrelloAccessor implements TrelloOperations {

	private final OrganizationOperations organizationOperations;
	private final ListOperations listOperations;
	private final ChecklistOperations checklistOperations;
	private final MemberOperations memberOperations;
	private final NotificationOperations notificationOperations;
	private final TokenOperations tokenOperations;
	private final TypeOperations typeOperations;
	private final TrelloObjectFactoryImpl trelloObjFactory;

	public TrelloTemplate(String apiKey) {
		this(apiKey, null);
	}

	public TrelloTemplate(String apiKey, String token) {
		super(apiKey, token);

		trelloObjFactory = new TrelloObjectFactoryImpl();

		organizationOperations = new DefaultOrganizationOperations(apiKey, token, trelloObjFactory);
		listOperations = new DefaultListOperations(apiKey, token, trelloObjFactory);
		checklistOperations = new DefaultChecklistOperations(apiKey, token, trelloObjFactory);
		memberOperations = new DefaultMemberOperations(apiKey, token, trelloObjFactory);
		notificationOperations = new DefaultNotificationOperations(apiKey, token, trelloObjFactory);
		tokenOperations = new DefaultTokenOperations(apiKey, token, trelloObjFactory);
		typeOperations = new DefaultTypeOperations(apiKey, token, trelloObjFactory);
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
	public ListOperations getListOperations() {
		return listOperations;
	}

	@Override
	public ChecklistOperations getChecklistOperations() {
		return checklistOperations;
	}

	@Override
	public MemberOperations getMemberOperations() {
		return memberOperations;
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
		return new DefaultCardOperations(apiKey, token, trelloObjFactory, cardId);
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

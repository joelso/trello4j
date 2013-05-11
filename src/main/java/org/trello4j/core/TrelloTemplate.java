package org.trello4j.core;

import org.trello4j.TrelloException;
import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloOperations;

/**
 * The Class TrelloImpl.
 */
public class TrelloTemplate implements TrelloOperations {

	private final ActionOperations actionOperations;
	private final OrganizationOperations organizationOperations;
	private final ListOperations listOperations;
	private final ChecklistOperations checklistOperations;
	private final MemberOperations memberOperations;
	private final BoardOperations boardOperations;
	private final NotificationOperations notificationOperations;
	private final CardOperations cardOperations;
	private final TokenOperations tokenOperations;
	private final TypeOperations typeOperations;

	public TrelloTemplate(String apiKey) {
		this(apiKey, null);
	}

	public TrelloTemplate(String apiKey, String token) {
		if (apiKey == null) {
			throw new TrelloException("API key must be set, get one here: https://trello.com/1/appKey/generate");
		}

		final TrelloObjectFactoryImpl trelloObjFactory = new TrelloObjectFactoryImpl();

		actionOperations = new DefaultActionOperations(apiKey, token, trelloObjFactory);
		organizationOperations = new DefaultOrganizationOperations(apiKey, token, trelloObjFactory);
		listOperations = new DefaultListOperations(apiKey, token, trelloObjFactory);
		checklistOperations = new DefaultChecklistOperations(apiKey, token, trelloObjFactory);
		memberOperations = new DefaultMemberOperations(apiKey, token, trelloObjFactory);
		boardOperations = new DefaultBoardOperations(apiKey, token, trelloObjFactory);
		notificationOperations = new DefaultNotificationOperations(apiKey, token, trelloObjFactory);
		cardOperations = new DefaultCardOperations(apiKey, token, trelloObjFactory);
		tokenOperations = new DefaultTokenOperations(apiKey, token, trelloObjFactory);
		typeOperations = new DefaultTypeOperations(apiKey, token, trelloObjFactory);
	}

	@Override
	public ActionOperations getActionOperations() {
		return actionOperations;
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
	public BoardOperations getBoardOperations() {
		return boardOperations;
	}

	@Override
	public NotificationOperations getNotificationOperations() {
		return notificationOperations;
	}

	@Override
	public CardOperations getCardOperations() {
		return cardOperations;
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

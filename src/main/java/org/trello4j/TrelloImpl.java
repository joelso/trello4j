package org.trello4j;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.trello4j.core.ActionOperations;
import org.trello4j.core.BoardOperations;
import org.trello4j.core.CardOperations;
import org.trello4j.core.ChecklistOperations;
import org.trello4j.core.DefaultActionOperations;
import org.trello4j.core.DefaultBoardOperations;
import org.trello4j.core.DefaultCardOperations;
import org.trello4j.core.DefaultChecklistOperations;
import org.trello4j.core.DefaultListOperations;
import org.trello4j.core.DefaultMemberOperations;
import org.trello4j.core.DefaultNotificationOperations;
import org.trello4j.core.DefaultOrganizationOperations;
import org.trello4j.core.DefaultTokenOperations;
import org.trello4j.core.DefaultTypeOperations;
import org.trello4j.core.ListOperations;
import org.trello4j.core.MemberOperations;
import org.trello4j.core.NotificationOperations;
import org.trello4j.core.OrganizationOperations;
import org.trello4j.core.TokenOperations;
import org.trello4j.core.TypeOperations;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Board.Prefs;
import org.trello4j.model.Card;
import org.trello4j.model.Card.Attachment;
import org.trello4j.model.Checklist;
import org.trello4j.model.Checklist.CheckItem;
import org.trello4j.model.Member;
import org.trello4j.model.Notification;
import org.trello4j.model.Organization;
import org.trello4j.model.Token;
import org.trello4j.model.Type;

/**
 * The Class TrelloImpl.
 */
public class TrelloImpl implements Trello {

	private final ActionOperations actionOperationsDelegate;
	private final OrganizationOperations organizationOperationsDelegate;
	private final ListOperations listOperationsDelegate;
	private final ChecklistOperations checklistOperations;
	private final MemberOperations memberOperations;
	private final BoardOperations boardOperations;
	private final NotificationOperations notificationOperations;
	private final CardOperations cardOperations;
	private final TokenOperations tokenOperations;
	private final TypeOperations typeOperations;

	public TrelloImpl(String apiKey) {
		this(apiKey, null);
	}

	public TrelloImpl(String apiKey, String token) {
		if (apiKey == null) {
			throw new TrelloException("API key must be set, get one here: https://trello.com/1/appKey/generate");
		}

		final TrelloObjectFactoryImpl trelloObjFactory = new TrelloObjectFactoryImpl();

		actionOperationsDelegate = new DefaultActionOperations(apiKey, token, trelloObjFactory);
		organizationOperationsDelegate = new DefaultOrganizationOperations(apiKey, token, trelloObjFactory);
		listOperationsDelegate = new DefaultListOperations(apiKey, token, trelloObjFactory);
		checklistOperations = new DefaultChecklistOperations(apiKey, token, trelloObjFactory);
		memberOperations = new DefaultMemberOperations(apiKey, token, trelloObjFactory);
		boardOperations = new DefaultBoardOperations(apiKey, token, trelloObjFactory);
		notificationOperations = new DefaultNotificationOperations(apiKey, token, trelloObjFactory);
		cardOperations = new DefaultCardOperations(apiKey, token, trelloObjFactory);
		tokenOperations = new DefaultTokenOperations(apiKey, token, trelloObjFactory);
		typeOperations = new DefaultTypeOperations(apiKey, token, trelloObjFactory);
	}

	@Override
	public Board getBoard(final String boardId) {
		return boardOperations.getBoard(boardId);
	}

	@Override
	public List<Action> getActionsByBoard(final String boardId, final String... filter) {
		return boardOperations.getActionsByBoard(boardId, filter);
	}

	@Override
	public List<Card> getCardsByBoard(String boardId, final String... filter) {
		return boardOperations.getCardsByBoard(boardId, filter);
	}

	@Override
	public List<Checklist> getChecklistByBoard(String boardId) {
		return boardOperations.getChecklistByBoard(boardId);
	}

	@Override
	public List<org.trello4j.model.List> getListByBoard(String boardId, final String... filter) {
		return boardOperations.getListByBoard(boardId, filter);
	}

	@Override
	public List<Member> getMembersByBoard(String boardId, final String... filter) {
		return boardOperations.getMembersByBoard(boardId, filter);
	}

	@Override
	public List<Member> getMembersInvitedByBoard(String boardId, final String... filter) {
		return boardOperations.getMembersInvitedByBoard(boardId, filter);
	}

	@Override
	public Prefs getPrefsByBoard(String boardId) {
		return boardOperations.getPrefsByBoard(boardId);
	}

	@Override
	public Organization getOrganizationByBoard(String boardId, final String... filter) {
		return boardOperations.getOrganizationByBoard(boardId, filter);
	}

	@Override
	public Member getMember(String usernameOrId, final String... filter) {
		return memberOperations.getMember(usernameOrId, filter);
	}

	@Override
	public List<Board> getBoardsByMember(String usernameOrId, final String... filter) {
		return memberOperations.getBoardsByMember(usernameOrId, filter);
	}

	@Override
	public Card getCard(final String cardId) {
		return cardOperations.getCard(cardId);
	}

	@Override
	public List<Action> getActionsByCard(final String cardId) {
		return cardOperations.getActionsByCard(cardId);
	}

	@Override
	public List<Attachment> getAttachmentsByCard(final String cardId) {
		return cardOperations.getAttachmentsByCard(cardId);
	}

	@Override
	public Board getBoardByCard(final String cardId, final String... filter) {
		return cardOperations.getBoardByCard(cardId, filter);
	}

	@Override
	public List<CheckItem> getCheckItemStatesByCard(final String cardId) {
		return cardOperations.getCheckItemStatesByCard(cardId);
	}

	@Override
	public List<Checklist> getChecklistByCard(final String cardId) {
		return cardOperations.getChecklistByCard(cardId);
	}

	@Override
	public org.trello4j.model.List getListByCard(final String cardId, final String... filter) {
		return cardOperations.getListByCard(cardId, filter);
	}

	@Override
	public List<Member> getMembersByCard(final String cardId) {
		return cardOperations.getMembersByCard(cardId);
	}

	@Override
	public Card createCard(String idList, String name, Map<String, Object> keyValueMap, String... filter) {
		return cardOperations.createCard(idList, name, keyValueMap, filter);
	}

	@Override
	public Action commentOnCard(String idCard, String text, String... filter) {
		return cardOperations.commentOnCard(idCard, text, filter);
	}

	@Override
	public List<Attachment> attachToCard(String idCard, File file, URL attachmentUrl, String name, String mimeType, String... filter) {
		return cardOperations.attachToCard(idCard, file, attachmentUrl, name, mimeType, filter);
	}

	@Override
	public Checklist addChecklist(String idCard, String idChecklist, String checklistName, String idChecklistSource, String... filter) {
		return cardOperations.addChecklist(idCard, idChecklist, checklistName, idChecklistSource, filter);
	}

	@Override
	public List<Card.Label> addLabel(String idCard, String label, String... filter) {
		return cardOperations.addLabel(idCard, label, filter);
	}

	@Override
	public List<Member> addMember(String idCard, String memberId, String... filter) {
		return cardOperations.addMember(idCard, memberId, filter);
	}

	@Override
	public boolean voteOnCard(String idCard, String memberId, String... filter) {
		return voteOnCard(idCard, memberId, filter);
	}

	@Override
	public List<Member> getMemberVotesOnCard(String idCard, String... filter) {
		return cardOperations.getMemberVotesOnCard(idCard, filter);
	}

	@Override
	public boolean deleteCard(String idCard, String... filter) {
		return cardOperations.deleteCard(idCard, filter);
	}

	@Override
	public boolean deleteChecklistFromCard(String idCard, String idList, String... filter) {
		return cardOperations.deleteChecklistFromCard(idCard, idList, filter);
	}

	@Override
	public boolean deleteLabelFromCard(String idCard, String color, String... filter) {
		return cardOperations.deleteLabelFromCard(idCard, color, filter);
	}

	@Override
	public boolean deleteMemberFromCard(String idCard, String idMember, String... filter) {
		return cardOperations.deleteMemberFromCard(idCard, idMember, filter);
	}

	@Override
	public boolean deleteVoteFromCard(String idCard, String memberId, String... filter) {
		return deleteVoteFromCard(idCard, memberId, filter);
	}

	@Override
	public org.trello4j.model.List getList(final String listId) {
		return listOperationsDelegate.getList(listId);
	}

	@Override
	public Notification getNotification(String notificationId, final String... filter) {
		return notificationOperations.getNotification(notificationId, filter);
	}

	@Override
	public Checklist getChecklist(String checklistId, final String... filter) {
		return checklistOperations.getChecklist(checklistId, filter);
	}

	@Override
	public Type getType(String idOrName) {
		return typeOperations.getType(idOrName);
	}

	@Override
	public Board getBoardByNotification(String notificationId, final String... filter) {
		return notificationOperations.getBoardByNotification(notificationId, filter);
	}

	@Override
	public Card getCardByNotification(String notificationId, final String... filter) {
		return notificationOperations.getCardByNotification(notificationId, filter);
	}

	@Override
	public org.trello4j.model.List getListByNotification(String notificationId, final String... filter) {
		return notificationOperations.getListByNotification(notificationId, filter);
	}

	@Override
	public Member getMemberByNotification(String notificationId, final String... filter) {
		return notificationOperations.getMemberByNotification(notificationId, filter);
	}

	@Override
	public Member getMemberCreatorByNotification(String notificationId, final String... filter) {
		return notificationOperations.getMemberCreatorByNotification(notificationId, filter);
	}

	@Override
	public Member getOrganizationCreatorByNotification(String notificationId, final String... filter) {
		return notificationOperations.getOrganizationCreatorByNotification(notificationId, filter);
	}

	@Override
	public List<Action> getActionsByList(String listId) {
		return listOperationsDelegate.getActionsByList(listId);
	}

	@Override
	public Board getBoardByList(String listId, final String... filter) {
		return listOperationsDelegate.getBoardByList(listId, filter);
	}

	@Override
	public List<Card> getCardsByList(String listId, final String... filter) {
		return listOperationsDelegate.getCardsByList(listId, filter);
	}

	@Override
	public List<Action> getActionsByMember(String usernameOrId) {
		return memberOperations.getActionsByMember(usernameOrId);
	}

	@Override
	public List<Card> getCardsByMember(String usernameOrId, final String... filter) {
		return memberOperations.getCardsByMember(usernameOrId, filter);
	}

	@Override
	public List<Notification> getNotificationsByMember(String usernameOrId, final String... filter) {
		return memberOperations.getNotificationsByMember(usernameOrId, filter);
	}

	@Override
	public List<Organization> getOrganizationsByMember(String usernameOrId, final String... filter) {
		return memberOperations.getOrganizationsByMember(usernameOrId, filter);
	}

	@Override
	public List<Organization> getOrganizationsInvitedByMember(String usernameOrId, final String... filter) {
		return memberOperations.getOrganizationsInvitedByMember(usernameOrId, filter);
	}

	@Override
	public Board getBoardByChecklist(String checklistId, final String... filter) {
		return checklistOperations.getBoardByChecklist(checklistId, filter);
	}

	@Override
	public List<CheckItem> getCheckItemsByChecklist(String checklistId) {
		return checklistOperations.getCheckItemsByChecklist(checklistId);
	}

	@Override
	public List<Card> getCardByChecklist(String checklistId, final String... filter) {
		return getCardByChecklist(checklistId, filter);
	}

	@Override
	public Token getToken(String tokenId, final String... filter) {
		return tokenOperations.getToken(tokenId, filter);
	}

	@Override
	public Member getMemberByToken(String tokenId, final String... filter) {
		return tokenOperations.getMemberByToken(tokenId, filter);
	}

	@Override
	public Action getAction(String actionId, String... filter) {
		return actionOperationsDelegate.getAction(actionId, filter);
	}

	@Override
	public Board getBoardByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getBoardByAction(actionId, filter);
	}

	@Override
	public Card getCardByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getCardByAction(actionId, filter);
	}

	@Override
	public Member getMemberByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getMemberByAction(actionId, filter);
	}

	@Override
	public Member getMemberCreatorByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getMemberCreatorByAction(actionId, filter);
	}

	@Override
	public Organization getOrganizationByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getOrganizationByAction(actionId, filter);
	}

	@Override
	public org.trello4j.model.List getListByAction(String actionId, String... filter) {
		return actionOperationsDelegate.getListByAction(actionId, filter);
	}

	@Override
	public Organization getOrganization(String organizationNameOrId, String... filter) {
		return organizationOperationsDelegate.getOrganization(organizationNameOrId, filter);
	}

	@Override
	public List<Board> getBoardsByOrganization(String organizationNameOrId, String... filter) {
		return organizationOperationsDelegate.getBoardsByOrganization(organizationNameOrId, filter);
	}

	@Override
	public List<Action> getActionsByOrganization(String organizationNameOrId) {
		return organizationOperationsDelegate.getActionsByOrganization(organizationNameOrId);
	}

	@Override
	public List<Member> getMembersByOrganization(String organizationNameOrId, String... filter) {
		return organizationOperationsDelegate.getMembersByOrganization(organizationNameOrId, filter);
	}

}

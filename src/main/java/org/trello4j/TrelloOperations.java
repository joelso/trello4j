package org.trello4j;

import org.trello4j.core.ActionOperations;
import org.trello4j.core.BoardOperations;
import org.trello4j.core.CardOperations;
import org.trello4j.core.ChecklistOperations;
import org.trello4j.core.ListOperations;
import org.trello4j.core.MemberOperations;
import org.trello4j.core.NotificationOperations;
import org.trello4j.core.OrganizationOperations;
import org.trello4j.core.TokenOperations;

public interface TrelloOperations {

	ActionOperations boundActionOperations(String actionId);

	OrganizationOperations getOrganizationOperations();

	ListOperations boundListOperations(String listId);

	ChecklistOperations boundChecklistOperations(String checklistId);

	MemberOperations boundMemberOperations(String usernameOrId);

	BoardOperations boundBoardOperations(String boardId);

	NotificationOperations boundNotificationOperations(String notificationId);

	CardOperations boundCardOperations(String cardId);

	TokenOperations getTokenOperations();
}
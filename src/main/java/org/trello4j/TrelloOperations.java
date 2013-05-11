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
import org.trello4j.core.TypeOperations;

public interface TrelloOperations {

	ActionOperations getActionOperations();

	OrganizationOperations getOrganizationOperations();

	ListOperations getListOperations();

	ChecklistOperations getChecklistOperations();

	MemberOperations getMemberOperations();

	BoardOperations getBoardOperations();

	NotificationOperations getNotificationOperations();

	CardOperations getCardOperations();

	TokenOperations getTokenOperations();

	TypeOperations getTypeOperations();

}
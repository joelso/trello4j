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

/**
 * The Interface Trello.
 */
public interface Trello extends OrganizationOperations, NotificationOperations, BoardOperations, CardOperations, ListOperations, MemberOperations, ChecklistOperations, TokenOperations,
		ActionOperations, TypeOperations {

}
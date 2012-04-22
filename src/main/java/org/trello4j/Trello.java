package org.trello4j;


import org.trello4j.model.Type;

public interface Trello extends
		OrganizationService, 
		NotificationService, 
		BoardService, 
		CardService,
		ActionService,
		ListService,
		MemberService,
        ChecklistService {

    Type getType(String idOrName);

}
package org.trello4j;

import org.trello4j.model.Checklist;
import org.trello4j.model.List;


/**
 *
 * @author joel
 */
public interface ChecklistService {

    /**
     * Get checklist by given id.
     * @param checklistId
     * @return
     */
	Checklist getChecklist(String checklistId);
	
}
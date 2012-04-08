package org.trello4j;

import org.trello4j.model.Action;


/**
 * 
 * @author joel
 * 
 */
public interface ActionService {
	
	/**
	 * Get action of current ID
	 * @param actionId
	 * @return
	 */
	Action getAction(String actionId);

}
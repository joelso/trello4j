package org.trello4j;

import java.util.List;

import org.trello4j.model.Board;
import org.trello4j.model.Organization;

public interface OrganizationService {
	
	/**
	 * Get organization of given ID.
	 * @param organizationName
	 * @return
	 */
	Organization getOrganization(String organizationName);
	
	/**
	 * Get list of boards that belong to organization.
	 * @param organizationName
	 * @return list of boards
	 */
	List<Board> getBoardsByOrganization(String organizationName);
	
}
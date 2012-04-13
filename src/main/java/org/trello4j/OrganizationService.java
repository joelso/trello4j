package org.trello4j;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Organization;

import java.util.List;

/**
 * Implemented methods:
 * <ul>
 * 	<li>GET /1/organizations/[org_id or name]</li>
 * 	<li>GET /1/organizations/[org_id or name]/boards</li> 
 * </ul>
 * 
 * 
 * To be implemented:
 * <ul>
 * 	<li>GET /1/organizations/[org_id or name]/[field]</li> 
 * 	<li>GET /1/organizations/[org_id or name]/actions</li>
 * 	<li>GET /1/organizations/[org_id or name]/boards/[filter]</li> 
 * 	<li>GET /1/organizations/[org_id or name]/members</li> 
 * 	<li>GET /1/organizations/[org_id or name]/members/[filter]</li> 
 * 	<li>PUT /1/organizations/[org_id or name]</li> 
 * 	<li>PUT /1/organizations/[org_id or name]/desc</li>
 * 	<li>PUT /1/organizations/[org_id or name]/displayName</li> 
 * 	<li>PUT /1/organizations/[org_id or name]/name</li> 
 * 	<li>PUT /1/organizations/[org_id or name]/website</li> 
 * 	<li>POST /1/organizations DELETE /1/organizations/[org_id or name]</li>
 * </ul>
 * 
 * @author joel
 * 
 */
public interface OrganizationService {

	/**
	 * Get organization of given ID.
	 * 
	 * @param organizationName
	 * @return
	 */
	Organization getOrganization(String organizationName);

	/**
	 * Get list of boards that belong to organization.
	 * 
	 * @param organizationNameOrId
	 * @return list of boards
	 */
	List<Board> getBoardsByOrganization(String organizationNameOrId);

    /**
     *
     * @param organizationNameOrId
     * @return
     */
    List<Action> getActionsByOrganization(String organizationNameOrId);

}
package org.trello4j;

import java.util.List;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;

/**
 * Implemented methods:
 * <ul>
 * <li>GET /1/organizations/[org_id or name]</li>
 * <li>GET /1/organizations/[org_id or name]/boards</li>
 * <li>GET /1/organizations/[org_id or name]/actions</li>
 * </ul>
 * 
 * 
 * To be implemented:
 * <ul>
 * <li>GET /1/organizations/[org_id or name]/[field]</li>
 * <li>GET /1/organizations/[org_id or name]/boards/[filter]</li>
 * <li>GET /1/organizations/[org_id or name]/members</li>
 * <li>GET /1/organizations/[org_id or name]/members/[filter]</li>
 * <li>PUT /1/organizations/[org_id or name]</li>
 * <li>PUT /1/organizations/[org_id or name]/desc</li>
 * <li>PUT /1/organizations/[org_id or name]/displayName</li>
 * <li>PUT /1/organizations/[org_id or name]/name</li>
 * <li>PUT /1/organizations/[org_id or name]/website</li>
 * <li>POST /1/organizations DELETE /1/organizations/[org_id or name]</li>
 * </ul>
 * .
 * 
 * @author joel
 */
public interface OrganizationService {

	/**
	 * Get organization of given ID or name.
	 * 
	 * @param organizationNameOrId
	 *            the organization name or id
	 * @return the organization
	 */
	Organization getOrganization(String organizationNameOrId, String... filter);

	/**
	 * Get list of boards that belong to organization.
	 * 
	 * @param organizationNameOrId
	 *            the organization name or id
	 * @return list of boards
	 */
	List<Board> getBoardsByOrganization(String organizationNameOrId,
			String... filter);

	/**
	 * Get list of actions related to given organization.
	 * 
	 * @param organizationNameOrId
	 *            the organization name or id
	 * @return the actions by organization
	 */
	List<Action> getActionsByOrganization(String organizationNameOrId);

	/**
	 * Gets the members by organization.
	 * 
	 * @param organizationNameOrId
	 *            the organization name or id
	 * @return the members by organization
	 */
	List<Member> getMembersByOrganization(String organizationNameOrId,
			String... filter);

}
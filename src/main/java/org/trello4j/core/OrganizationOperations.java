package org.trello4j.core;

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
 */

public interface OrganizationOperations {

	Organization get(String... filters);

	List<Board> getBoards(String... filters);

	List<Action> getActions();

	List<Member> getMembers(String... filters);

}
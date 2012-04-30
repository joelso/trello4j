package org.trello4j;

import java.util.List;

import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;
import org.trello4j.model.Board.Prefs;



/**
 * Implemented methods:
 * <ul>
 * <li>GET /1/boards/[board_id]</li>
 * <li>GET /1/boards/[board_id]/actions</li>
 * </ul>
 * 
 * 
 * To be implemented:
 * <ul>
 * <li>GET /1/boards/[board_id]/[field]                 </li>
 * <li>GET /1/boards/[board_id]/cards                   </li>
 * <li>GET /1/boards/[board_id]/cards/[filter]          </li>
 * <li>GET /1/boards/[board_id]/cards/[idCard]          </li>
 * <li>GET /1/boards/[board_id]/checklists              </li>
 * <li>GET /1/boards/[board_id]/lists                   </li>
 * <li>GET /1/boards/[board_id]/lists/[filter]          </li>
 * <li>GET /1/boards/[board_id]/members                 </li>
 * <li>GET /1/boards/[board_id]/members/[filter]        </li>
 * <li>GET /1/boards/[board_id]/membersInvited          </li>
 * <li>GET /1/boards/[board_id]/membersInvited/[field]  </li>
 * <li>GET /1/boards/[board_id]/myPrefs                 </li>
 * <li>GET /1/boards/[board_id]/organization            </li>
 * <li>GET /1/boards/[board_id]/organization/[field]    </li>
 * <li>PUT /1/boards/[board_id]                         </li>
 * <li>PUT /1/boards/[board_id]/closed                  </li>
 * <li>PUT /1/boards/[board_id]/desc                    </li>
 * <li>PUT /1/boards/[board_id]/name                    </li>
 * <li>POST /1/boards                                   </li>
 * <li>POST /1/boards/[board_id]/checklists             </li>
 * <li>POST /1/boards/[board_id]/lists                  </li>
 * <li>POST /1/boards/[board_id]/myPrefs                </li>
 * </ul>.
 *
 * @author joel
 */
public interface BoardService {
	
	/**
	 * Get board of given ID.
	 *
	 * @param boardId the board id
	 * @return the board
	 */
	Board getBoard(String boardId);
	
	/**
	 * Get list of actions that belongs to given board.
	 *
	 * @param boardId the board id
	 * @param filter the filter
	 * @return list of actions
	 */
	List<Action> getActionsByBoard(String boardId, String... filter);

	/**
	 * Gets the board my prefs.
	 *
	 * @param boardId the board id
	 * @return the board my prefs
	 */
	Board getBoardMyPrefs(String boardId);

	/**
	 * Gets the organization by board.
	 *
	 * @param boardId the board id
	 * @return the organization by board
	 */
	Organization getOrganizationByBoard(String boardId);

	/**
	 * Gets the members invited by board.
	 *
	 * @param boardId the board id
	 * @return the members invited by board
	 */
	List<Member> getMembersInvitedByBoard(String boardId);

	/**
	 * Gets the members by board.
	 *
	 * @param boardId the board id
	 * @return the members by board
	 */
	List<Member> getMembersByBoard(String boardId);

	/**
	 * Gets the list by board.
	 *
	 * @param boardId the board id
	 * @return the list by board
	 */
	List<org.trello4j.model.List> getListByBoard(String boardId);

	/**
	 * Gets the checklist by board.
	 *
	 * @param boardId the board id
	 * @return the checklist by board
	 */
	List<Checklist> getChecklistByBoard(String boardId);

	/**
	 * Gets the cards by board.
	 *
	 * @param boardId the board id
	 * @return the cards by board
	 */
	List<Card> getCardsByBoard(String boardId);
	
	/**
	 * Gets the prefs by board.
	 *
	 * @param boardId the board id
	 * @return the prefs by board
	 */
	Prefs getPrefsByBoard(String boardId);


}
package org.trello4j;

import java.util.List;

import org.trello4j.model.Action;
import org.trello4j.model.Board;


/**
 * Implemented methods:
 * <ul>
 * 	<li>GET /1/boards/[board_id]</li>
 * 	<li>GET /1/boards/[board_id]/actions</li>
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
 * </ul>
 * 
 * @author joel
 * 
 */
public interface BoardService {
	
	/**
	 * Get board of given ID.
	 * 
	 * @param boardId
	 * @return
	 */
	Board getBoard(String boardId);
	
	/**
	 * Get list of actions that belongs to given board.
	 * 
	 * @param boardId
     * @param filter
	 * @return list of actions
	 */
	List<Action> getActionsByBoard(String boardId, String... filter);


}
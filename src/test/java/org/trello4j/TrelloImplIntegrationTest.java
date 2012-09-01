package org.trello4j;

import org.junit.Test;
import org.trello4j.model.*;
import org.trello4j.model.Board.PERMISSION_TYPE;

import java.util.List;

import static org.junit.Assert.*;


/**
 * The Class TrelloImplIntegrationTest.
 */
public class TrelloImplIntegrationTest {

	private static final String API_KEY = "23ec668887f03d4c71c7f74fb0ae30a4";
	private static final String API_TOKEN = "ede7758ace3911eb83585b15d9cbb14a02542e4556d14e7314d0e24228c578ae";

	@Test(expected = TrelloException.class)
	public void missingApiKey_shouldThrowException() {
		new TrelloImpl(null);
	}

	@Test(expected=TrelloException.class)
	public void testInvalidObjectId() {
		// GIVEN		
		String boardId = "INVALID_ID"; 
		
		// WHEN
		Board board = new TrelloImpl(API_KEY, null).getBoard(boardId);
		
		// THEN
		assertNull("Oops, board is null", board);
	}

	@Test
	public void test404_shouldReturnNull() {
		// GIVEN		
		String boardId = "00000000000000000000000c"; 
		
		// WHEN
		Board board = new TrelloImpl(API_KEY, null).getBoard(boardId);
		
		// THEN
		assertNull("Oops, board is null", board);
	}

	@Test
	public void shouldReturnPublicBoard() {
		// GIVEN
		String boardId = "4d5ea62fd76aa1136000000c"; // ID of Trello Development

		// WHEN
		Board board = new TrelloImpl(API_KEY, null).getBoard(boardId);

		// THEN
		assertNotNull("Oops, board is null", board);
		assertEquals("Incorrect board id", boardId, board.getId());
		assertEquals("Incorrect name of board", "Trello Development", board.getName());
		assertEquals("Incorrect organization id", "4e1452614e4b8698470000e0", board.getIdOrganization());
		assertEquals("Incorrect url", "https://trello.com/board/trello-development/4d5ea62fd76aa1136000000c", board.getUrl());
		assertFalse("This should be an open board", board.isClosed());
		assertNotNull(board.getDesc());
		assertNotNull(board.getPrefs());
		assertEquals(PERMISSION_TYPE.PUBLIC, board.getPrefs().getVoting());
	}

	@Test
	public void shouldReturnAction() {
		// GIVEN
		String actionId = "4f7fc98a31f53721037b7bdd";

		// WHEN
		Action action = new TrelloImpl(API_KEY, null).getAction(actionId);

		// THEN
		assertNotNull("Oops, action is null", action);
		assertEquals("Incorrect action id", actionId, action.getId());
		assertNotNull("Date not set", action.getDate());
		assertNotNull("idMemberCreator not set", action.getIdMemberCreator());

		assertNotNull("memberCreator not set", action.getMemberCreator());
		assertNotNull("memberCreator.id not set", action.getMemberCreator().getId());
		assertNotNull("memberCreator.username not set", action.getMemberCreator().getUsername());
		assertNotNull("memberCreator.fullName not set", action.getMemberCreator().getFullName());
		assertNotNull("memberCreator.initials not set", action.getMemberCreator().getInitials());

		assertNotNull("data not set", action.getData());
		assertNotNull("data.text not set", action.getData().getText());
		assertNotNull("data.board not set", action.getData().getBoard());
		assertNotNull("data.board.id not set", action.getData().getBoard().getId());
		assertNotNull("data.board.name not set", action.getData().getBoard().getName());

	}

	@Test
	public void shouldReturnOrganization() {
		// GIVEN
		String organizationName = "fogcreek";

		// WHEN
		Organization org = new TrelloImpl(API_KEY, null).getOrganization(organizationName);

		// THEN
		assertNotNull("Oops, organization is null", org);
		assertEquals("Incorrect organization name", organizationName, org.getName());
	}

	@Test
	public void shouldReturnMemberByUsername() {
		// GIVEN
		String username = "joelsoderstrom";

		// WHEN
		Member member = new TrelloImpl(API_KEY, null).getMember(username);

		// THEN
		assertNotNull("Oops, member is null", member);
		assertNotNull("Avatar hash not set", member.getAvatarHash());
		assertEquals("Incorrect full name", "Joel Söderström", 	member.getFullName());
		assertNotNull("ID not set", member.getId());
		assertTrue("Invalid count of boards", member.getIdBoards().size() > 0);
		assertTrue("Invalid count of organizations", member.getIdOrganizations().size() > 0);
		assertEquals("Incorrect initials", "JS", member.getInitials());
		assertNotNull("Status not set", member.getStatus());
		assertEquals("Incorrect URL", "https://trello.com/joelsoderstrom", member.getUrl());
		assertEquals("Incorrect username", username, member.getUsername());
	}

	@Test
	public void shouldReturnMemberById() {
		// GIVEN
		String memberId = "4e918355e52581aa44eb0754";
		
		// WHEN
		Member member = new TrelloImpl(API_KEY, null).getMember(memberId);
		
		// THEN
		assertNotNull("Oops, member is null", member);
		assertEquals("Incorrect username", "joelsoderstrom", member.getUsername());
	}

	@Test
	public void shouldReturnBoardsByOrganization() {
		// GIVEN
		String organizationName = "fogcreek";
		String trelloDevBoardId = "4d5ea62fd76aa1136000000c";

		// WHEN
		List<Board> boards = new TrelloImpl(API_KEY, null).getBoardsByOrganization(organizationName);

		// THEN
		assertTrue("Organization should have at least one board", boards.size() > 0);
		assertTrue("Organization FogCreek should have Trello Development board", hasBoardWithId(boards, trelloDevBoardId));
	}

	@Test
	public void shouldReturnActionsByBoard() {
		// GIVEN
		String trelloDevBoardId = "4d5ea62fd76aa1136000000c";

		// WHEN
		List<Action> actions = new TrelloImpl(API_KEY, null).getActionsByBoard(trelloDevBoardId);

		// THEN
		assertTrue("Board should have at least one action", actions.size() > 0);
		assertEquals("Board id and action.data.board.id should be equal", trelloDevBoardId, actions.get(0).getData().getBoard().getId());
	}

	@Test
	public void shouldReturnCard() {
		// GIVEN
		String cardId = "4f6b93de58843df908f6266a";
		
		// WHEN
		Card card = new TrelloImpl(API_KEY, null).getCard(cardId);
		
		// THEN
		assertNotNull("Oops, card is null", card);
		assertEquals("Card id should be equal", cardId, card.getId());

		// if(!card.getAttachments().isEmpty()) {
		// 	assertNotNull("Attachment should be set", card.getAttachments().get(0).get_id());
		// }
	}

	@Test
	public void shouldReturnList() {
		// GIVEN
		String listId = "4e7b86d7ce194786721560b8";
		
		// WHEN
		org.trello4j.model.List list = new TrelloImpl(API_KEY, null).getList(listId);
		
		// THEN
		assertNotNull("Oops, list is null", list);
		assertEquals("Card id should be equal", listId, list.getId());
	}

	@Test
	public void shouldReturnNotification() {
		// GIVEN
		String notificationId = "4f82edfd34862b8473d92a8a";
		
		// WHEN
		Notification notification = new TrelloImpl(API_KEY, API_TOKEN).getNotification(notificationId);
		
		// THEN
		assertNotNull("Oops, notification is null", notification);
		assertEquals("Notification id should be equal", notificationId, notification.getId());
	}

    @Test
    public void shouldReturnBoardsByMember() {
        // GIVEN
        String userId = "userj";

        // WHEN
        List<Board> boards = new TrelloImpl(API_KEY, API_TOKEN).getBoardsByMember(userId);

        // THEN
        assertNotNull("Oops, board list is null", boards);
        assertTrue("Member should have at least one board", boards.size() > 0);
    }

    @Test
    public void shouldReturnActionsByOrganization() {
        // GIVEN
        String organizationName = "fogcreek";

        // WHEN
        List<Action> actions = new TrelloImpl(API_KEY, API_TOKEN).getActionsByOrganization(organizationName);

        // THEN
        assertNotNull("Oops, action list is null", actions);
        assertTrue("Organization should have at least one action", actions.size() > 0);
    }

    @Test
    public void shouldReturnChecklist() {
        // GIVEN
        String checklistId = "4f92b89ea73738db6cdd4ed7";

        // WHEN
        Checklist checklist = new TrelloImpl(API_KEY, API_TOKEN).getChecklist(checklistId);

        // THEN
        assertNotNull("Oops, checklist list is null", checklist);
        assertEquals("Checklist id should match", checklistId, checklist.getId());
    }

    @Test
    public void shouldReturnTypeById() {
        // GIVEN
        String typeId = "4eb3f3f1e679eb839b4c594b";

        // WHEN
        Type type = new TrelloImpl(API_KEY, null).getType(typeId);

        // THEN
        assertNotNull("Oops, type is null", type);
        assertEquals("Incorrect id", typeId, type.getId());
        assertEquals("Incorrect trello type", TrelloType.ORGANIZATION, type.getType());
    }

    @Test
    public void shouldReturnTypeByName() {
        // GIVEN
        String typeName = "fogcreek";

        // WHEN
        Type type = new TrelloImpl(API_KEY, null).getType(typeName);

        // THEN
        assertNotNull("Oops, type is null", type);
        assertEquals("Incorrect trello type", TrelloType.ORGANIZATION, type.getType());
    }


	/**
	 * Checks for board with id.
	 *
	 * @param boards the boards
	 * @param id the id
	 * @return true, if successful
	 */
	private boolean hasBoardWithId(List<Board> boards, String id) {
		boolean res = false;
		for (Board board : boards) {
			if (board.getId().equals(id)) {
				res = true;
				break;
			}
		}
		return res;
	}
}

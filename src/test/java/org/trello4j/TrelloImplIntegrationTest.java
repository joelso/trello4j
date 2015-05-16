package org.trello4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.trello4j.core.TrelloTemplate;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Board.PERMISSION_TYPE;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;
import org.trello4j.model.TrelloType;
import org.trello4j.model.Type;

/**
 * The Class TrelloImplIntegrationTest.
 */
public class TrelloImplIntegrationTest {

	private static final String API_KEY = "23ec668887f03d4c71c7f74fb0ae30a4";
	private static final String API_TOKEN = "ede7758ace3911eb83585b15d9cbb14a02542e4556d14e7314d0e24228c578ae";

	@Test(expected = TrelloException.class)
	public void missingApiKey_shouldThrowException() {
		new TrelloTemplate(null);
	}

	@Test(expected = TrelloException.class)
	public void testInvalidObjectId() {
		// GIVEN
		String boardId = "INVALID_ID";

		// WHEN
		Board board = new TrelloTemplate(API_KEY, null).boundBoardOperations(boardId).get();

		// THEN
		assertNull("Oops, board is null", board);
	}

	@Test
	public void test404_shouldReturnNull() {
		// GIVEN
		String boardId = "00000000000000000000000c";

		// WHEN
		Board board = new TrelloTemplate(API_KEY, null).boundBoardOperations(boardId).get();

		// THEN
		assertNull("Oops, board is null", board);
	}

	@Test
	public void shouldReturnPublicBoard() {
		// GIVEN
		String boardId = "4d5ea62fd76aa1136000000c"; // ID of Trello Development

		// WHEN
		Board board = new TrelloTemplate(API_KEY, null).boundBoardOperations(boardId).get();

		// THEN
		assertNotNull("Oops, board is null", board);
		assertEquals("Incorrect board id", boardId, board.getId());
		assertEquals("Incorrect name of board", "Trello Development", board.getName());
		assertEquals("Incorrect organization id", "4e1452614e4b8698470000e0", board.getIdOrganization());
		assertTrue("Incorrect url", board.getUrl().equals("https://trello.com/b/nC8QJJoZ/trello-development") ||
			board.getUrl().equals("https://trello.com/board/trello-development/4d5ea62fd76aa1136000000c"));
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
		Action action = new TrelloTemplate(API_KEY, null).boundActionOperations(actionId).get();

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
		Organization org = new TrelloTemplate(API_KEY, null).boundOrganizationOperations(organizationName).get();

		// THEN
		assertNotNull("Oops, organization is null", org);
		assertEquals("Incorrect organization name", organizationName, org.getName());
	}

	@Test
	public void shouldReturnMemberByUsername() {
		// GIVEN
		String username = "joelsoderstrom";

		// WHEN
		Member member = new TrelloTemplate(API_KEY, null).boundMemberOperations(username).get();

		// THEN
		assertNotNull("Oops, member is null", member);
		assertNotNull("Avatar hash not set", member.getAvatarHash());
		assertEquals("Incorrect full name", "Joel Söderström", member.getFullName());
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
		Member member = new TrelloTemplate(API_KEY, null).boundMemberOperations(memberId).get();

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
		List<Board> boards = new TrelloTemplate(API_KEY, null).boundOrganizationOperations(organizationName).getBoards();

		// THEN
		assertTrue("Organization should have at least one board", boards.size() > 0);
		assertTrue("Organization FogCreek should have Trello Development board", hasBoardWithId(boards, trelloDevBoardId));
	}

	@Test
	public void shouldReturnActionsByBoard() {
		// GIVEN
		String trelloDevBoardId = "4d5ea62fd76aa1136000000c";

		// WHEN
		List<Action> actions = new TrelloTemplate(API_KEY, null).boundBoardOperations(trelloDevBoardId).getActions();

		// THEN
		assertTrue("Board should have at least one action", actions.size() > 0);
		assertEquals("Board id and action.data.board.id should be equal", trelloDevBoardId, actions.get(0).getData().getBoard().getId());
	}

	@Test
	public void shouldReturnCard() {
		// GIVEN
		String cardId = "4f6b93de58843df908f6266a";

		// WHEN
		Card card = new TrelloTemplate(API_KEY, null).boundCardOperations(cardId).get();

		// THEN
		assertNotNull("Oops, card is null", card);
		assertEquals("Card id should be equal", cardId, card.getId());
		// If this fails, change the assert to time < card.getDateLastActivity(). The exact date doesn't matter
		// as long as it's not null and after the day the test failed.
		assertEquals("Card's dateLastActivity should be ok",
			new GregorianCalendar(2012, 7, 24, 17, 13, 24).getTimeInMillis() / 1000,
			card.getDateLastActivity().getTime() / 1000);

		// if(!card.getAttachments().isEmpty()) {
		// assertNotNull("Attachment should be set",
		// card.getAttachments().get(0).get_id());
		// }
	}

	@Test
	public void shouldReturnList() {
		// GIVEN
		String listId = "4e7b86d7ce194786721560b8";

		// WHEN
		org.trello4j.model.List list = new TrelloTemplate(API_KEY, null).boundListOperations(listId).get();

		// THEN
		assertNotNull("Oops, list is null", list);
		assertEquals("Card id should be equal", listId, list.getId());
	}

	@Test
	public void shouldReturnBoardsByMember() {
		// GIVEN
		String userId = "userj";

		// WHEN
		List<Board> boards = new TrelloTemplate(API_KEY, API_TOKEN).boundMemberOperations(userId).getBoards();

		// THEN
		assertNotNull("Oops, board list is null", boards);
		assertTrue("Member should have at least one board", boards.size() > 0);
	}

	@Test
	public void shouldReturnActionsByOrganization() {
		// GIVEN
		String organizationName = "fogcreek";

		// WHEN
		List<Action> actions = new TrelloTemplate(API_KEY, API_TOKEN).boundOrganizationOperations(organizationName).getActions();

		// THEN
		assertNotNull("Oops, action list is null", actions);
		assertTrue("Organization should have at least one action", actions.size() > 0);
	}

	@Test
	public void shouldReturnChecklist() {
		// GIVEN
		String checklistId = "4f92b89ea73738db6cdd4ed7";

		// WHEN
		Checklist checklist = new TrelloTemplate(API_KEY, API_TOKEN).boundChecklistOperations(checklistId).get();

		// THEN
		assertNotNull("Oops, checklist list is null", checklist);
		assertEquals("Checklist id should match", checklistId, checklist.getId());
	}

	@Test
	public void shouldReturnTypeById() {
		// GIVEN
		String typeId = "4eb3f3f1e679eb839b4c594b";

		// WHEN
		Type type = new TrelloTemplate(API_KEY, null).getType(typeId);

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
		Type type = new TrelloTemplate(API_KEY, null).getType(typeName);

		// THEN
		assertNotNull("Oops, type is null", type);
		assertEquals("Incorrect trello type", TrelloType.ORGANIZATION, type.getType());
	}

	/**
	 * Checks for board with id.
	 * 
	 * @param boards
	 *            the boards
	 * @param id
	 *            the id
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

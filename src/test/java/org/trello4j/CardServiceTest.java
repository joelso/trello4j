package org.trello4j;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.trello4j.core.TrelloTemplate;
import org.trello4j.model.Action;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Member;

/**
 * @author Johan Mynhardt
 */
public class CardServiceTest {

	// Note: this url was used to generate token with read, write permissions:
	// https://trello.com/1/authorize?key=23ec668887f03d4c71c7f74fb0ae30a4&name=My+Application&expiration=never&response_type=token&scope=read,write

	private static final String API_KEY = "23ec668887f03d4c71c7f74fb0ae30a4";
	private static final String API_TOKEN = "cfb1df98cbde193b3181e02a8bca9871eaeb8aed0659391f887631055b0b774d";

	@Test
	public void testCreateCard() {
		// GIVEN
		String listId = "4f82ed4f1903bae43e66f5fd";
		String name = "Trello4J CardService: Add Card using POST";
		String description = "Something awesome happened :)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("desc", description);

		// WHEN
		Card card = new TrelloTemplate(API_KEY, API_TOKEN).getListOperations().createCard(listId, name, map);

		// THEN
		assertNotNull(card);
		assertThat(card.getName(), equalTo(name));
		assertThat(card.getDesc(), equalTo(description));
	}

	@Test
	public void testCommentOnCard() {
		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		String commentText = "Comment text from JUnit test.";

		// WHEN
		Action action = new TrelloTemplate(API_KEY, API_TOKEN).getCardOperations().commentOnCard(idCard, commentText);

		// THEN
		assertNotNull(action);
		assertThat(action.getType(), equalTo(Action.TYPE.COMMENT_CARD));
		assertThat(action.getData().getText(), equalTo(commentText));
		assertThat(action.getData().getCard().getId(), equalTo(idCard));
	}

	@Test
	public void testAttachFileToCard() throws IOException {
		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		String fileContents = "foo bar text in file\n";
		File file = File.createTempFile("trello_attach_test", ".junit");
		if (!file.exists()) {
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(fileContents);
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				fail(e.toString());
			}
		}

		long size = file.length();
		String fileName = file.getName();

		// WHEN
		List<Card.Attachment> attachments = new TrelloTemplate(API_KEY, API_TOKEN).getCardOperations().attachToCard(idCard, file, null, null, null);
		file.deleteOnExit();

		// THEN
		assertNotNull(attachments);
		Card.Attachment attachment = attachments.get(attachments.size() - 1);

		assertThat(attachment.getName(), equalTo(fileName));
		assertThat(attachment.getBytes(), equalTo("" + size));
	}

	@Test
	public void testAttachFileFromUrl() throws IOException {
		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		URL url = new URL("https://trello.com/images/reco/Taco_idle.png");

		// WHEN
		List<Card.Attachment> attachments = new TrelloTemplate(API_KEY, API_TOKEN).getCardOperations().attachToCard(idCard, null, url, "Taco", null);

		// THEN
		assertNotNull(attachments);
		Card.Attachment attachment = attachments.get(attachments.size() - 1);
		assertNotNull(attachment);
		assertThat(attachment.getName(), equalTo("Taco"));
		assertTrue(attachment.getUrl().startsWith("http"));
		assertTrue(attachment.getUrl().endsWith("Taco_idle.png"));
	}

	@Test
	public void testAddChecklistToCard() throws IOException {
		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";

		// WHEN
		Checklist checklist = new TrelloTemplate(API_KEY, API_TOKEN).getCardOperations().addChecklist(idCard, null, null, null);

		// THEN
		assertNotNull(checklist);

		assertThat(checklist.getName(), equalTo("Checklist"));
		assertThat(checklist.getCheckItems().size(), equalTo(0));
	}

	@Test
	public void testAddLabelToCard() throws IOException {
		// TODO: prepare for test by removing all labels when the delete method
		// becomes available.

		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

		// WHEN
		trello.getCardOperations().deleteLabelFromCard(idCard, "blue");
		List<Card.Label> labels = trello.getCardOperations().addLabel(idCard, "blue");

		// THEN
		assertNotNull(labels);
		assertThat(labels.get(labels.size() - 1).getColor(), equalTo("blue"));
	}

	@Test
	public void testAddMemberToCard() throws IOException {
		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";

		TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);
		Member boardUser = trello.getMemberOperations().getMember("userj");

		// PREPARE CARD
		List<Member> cardMembers = trello.getCardOperations().getMembersByCard(idCard);
		if (!cardMembers.isEmpty()) {
			for (Member member : cardMembers) {
				trello.getCardOperations().deleteMemberFromCard(idCard, member.getId());
			}
		}

		// WHEN
		List<Member> membersAfterAdd = trello.getCardOperations().addMember(idCard, boardUser.getId());

		// THEN
		assertNotNull(membersAfterAdd);
		assertThat(membersAfterAdd.size(), equalTo(1));
		Member resultMember = membersAfterAdd.get(0);
		assertThat(resultMember.getId(), equalTo(boardUser.getId()));
	}

	@Test
	public void addMemberVote() throws IOException {
		TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		Member boardUser = trello.getMemberOperations().getMember("userj");
		assertNotNull(boardUser);

		// CLEANUP
		List<Member> votedMembers = trello.getCardOperations().getMemberVotesOnCard(idCard);
		if (votedMembers != null && !votedMembers.isEmpty()) {
			for (Member member : votedMembers) {
				trello.getCardOperations().deleteVoteFromCard(idCard, member.getId());
			}
		}
		// WHEN
		boolean voted = new TrelloTemplate(API_KEY, API_TOKEN).getCardOperations().voteOnCard(idCard, boardUser.getId());

		// THEN
		assertTrue(voted);
	}

	@Test
	public void deleteCard() {
		TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

		// GIVEN
		String idList = "4f82ed4f1903bae43e66f5fd";
		Card card = trello.getListOperations().createCard(idList, "jUnitCard", null);

		// WHEN
		boolean deletedCard = trello.getCardOperations().deleteCard(card.getId());

		// THEN
		assertTrue(deletedCard);
	}

	@Test
	public void deleteChecklistFromCard() {
		TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		Checklist checklist = trello.getCardOperations().addChecklist(idCard, null, null, null);

		// WHEN
		boolean deletedChecklist = trello.getCardOperations().deleteChecklistFromCard(idCard, checklist.getId());

		// THEN
		assertTrue(deletedChecklist);
	}

	@Test
	public void deleteLabelFromCard() {
		TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		Member member = trello.getMemberOperations().getMember("userj");

		// PREPARATION
		trello.getCardOperations().deleteLabelFromCard(idCard, "blue");
		trello.getCardOperations().addLabel(idCard, "blue");

		// WHEN
		boolean deleted = trello.getCardOperations().deleteLabelFromCard(idCard, "blue");

		// THEN
		assertTrue(deleted);
	}

	@Test
	public void deleteMemberFromCard() throws IOException {
		TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		Member member = trello.getMemberOperations().getMember("userj");

		// PREPARATION
		List<Member> members = trello.getCardOperations().getMembersByCard(idCard);
		boolean needToAddMember = true;
		for (Member cardMember : members) {
			if (cardMember.getId().equals(member.getId()))
				needToAddMember = false;
		}
		if (needToAddMember)
			trello.getCardOperations().addMember(idCard, member.getId());

		// WHEN
		boolean removedMemberFromCard = trello.getCardOperations().deleteMemberFromCard(idCard, member.getId());

		// THEN
		assertTrue(removedMemberFromCard);
	}

	@Test
	public void testDeleteMemberVoteFromCard() throws IOException {
		TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

		// GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		Member boardUser = trello.getMemberOperations().getMember("userj");
		assertNotNull(boardUser);

		List<Member> membersVoted = trello.getCardOperations().getMemberVotesOnCard(idCard);

		boolean needToAddVote = true;
		for (Member member : membersVoted) {
			if (member.getId().equals(boardUser.getId()))
				needToAddVote = false;
		}

		if (needToAddVote) {
			boolean addedVote = trello.getCardOperations().voteOnCard(idCard, boardUser.getId());
			assertTrue(addedVote);
		}

		// WHEN
		boolean removedFromCard = trello.getCardOperations().deleteVoteFromCard(idCard, boardUser.getId());

		// THEN
		assertTrue(removedFromCard);
	}
}

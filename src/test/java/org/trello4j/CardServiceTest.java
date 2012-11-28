package org.trello4j;

import org.junit.Test;
import org.trello4j.model.Action;
import org.trello4j.model.Card;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
		Card card = new TrelloImpl(API_KEY, API_TOKEN).createCard(listId, name, map);

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
		Action action = new TrelloImpl(API_KEY, API_TOKEN).commentOnCard(idCard, commentText);

		//THEN
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
		File file = File.createTempFile("trello_attach_test",".junit");
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
		List<Card.Attachment> attachments = new TrelloImpl(API_KEY, API_TOKEN).attachToCard(idCard, file, null, null, null);
		file.deleteOnExit();

		//THEN
		assertNotNull(attachments);
		Card.Attachment attachment = attachments.get(attachments.size()-1);

		assertThat(attachment.getName(), equalTo(fileName));
		assertThat(attachment.getBytes(), equalTo(""+size));
	}

	@Test
	public void testAttachFileFromUrl() throws IOException {
		//GIVEN
		String idCard = "50429779e215b4e45d7aef24";
		URL url = new URL("https://trello.com/images/reco/Taco_idle.png");

		//WHEN
		List<Card.Attachment> attachments = new TrelloImpl(API_KEY, API_TOKEN).attachToCard(idCard, null, url, "Taco", null);

		//THEN
		assertNotNull(attachments);
		Card.Attachment attachment = attachments.get(attachments.size()-1);
		assertNotNull(attachment);
		assertThat(attachment.getName(), equalTo("Taco"));
		assertTrue(attachment.getUrl().startsWith("http"));
		assertTrue(attachment.getUrl().endsWith("Taco_idle.png"));
	}
}

package org.trello4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.trello4j.model.Card;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Johan Mynhardt
 */
public class CardServiceTest {
	@Test
	public void testAddNewCardUsingPost() {
		Properties properties = new Properties();
		try {
			properties.load(CardServiceTest.class.getResourceAsStream("/cardservice.properties"));
		} catch (NullPointerException e) {
			fail("Could not load properties to test CardService: " + e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}

		String developerKey = properties.getProperty("developerKey");
		String token = properties.getProperty("token");
		String listId = properties.getProperty("listId");

		String name = "Trello4J CardService: Add Card using POST";
		String description = "Something awesome happened :)";

		Map<String, String> keyValueMap = new HashMap<String, String>();
		keyValueMap.put("desc", description);

		Trello trello = new TrelloImpl(developerKey, token);
		Card card = trello.createCard(listId, name, keyValueMap);

		assertNotNull(card);

		assertThat(card.getName(), equalTo(name));
		assertThat(card.getDesc(), equalTo(description));
	}
}

package org.trello4j;

import org.junit.Test;
import org.trello4j.model.Card;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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

		Map<String, String> map = new HashMap<String, String>();
        map.put("desc", description);

        // WHEN
		Card card = new TrelloImpl(API_KEY, API_TOKEN).createCard(listId, name, map);

        // THEN
		assertNotNull(card);
		assertThat(card.getName(), equalTo(name));
		assertThat(card.getDesc(), equalTo(description));
	}
}

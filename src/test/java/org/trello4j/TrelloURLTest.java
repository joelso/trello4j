package org.trello4j;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.trello4j.model.Action;


/**
 * Created with IntelliJ IDEA.
 * User: joel
 * Date: 2012-04-15
 * Time: 11:00 AM
 */
public class TrelloURLTest {

    /**
     * Should build url with filter.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldBuildURLWithFilter() throws Exception {
        String url = TrelloURL.create("API_KEY", TrelloURL.ACTION_URL, "ID")
                .token("TOKEN")
                .filter(Action.TYPE.ADD_ATTACHMENT, Action.TYPE.ADD_CHECKLIST)
                .build();

        String expectedUrl = "https://api.trello.com/1/actions/ID?key=API_KEY&token=TOKEN&filter=" + Action.TYPE.ADD_ATTACHMENT + "," + Action.TYPE.ADD_CHECKLIST;

        assertEquals(expectedUrl, url);
    }

	@Test
	public void shouldNotReturnNullBaseURL() {
		String url = TrelloURL
				.create("API_KEY", TrelloURL.CARD_POST_URL)
				.token("TOKEN")
				.build();

		String expectedUrl = "https://api.trello.com/1/cards?key=API_KEY&token=TOKEN";

		assertEquals(expectedUrl, url);
	}
}

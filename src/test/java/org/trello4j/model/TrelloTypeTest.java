package org.trello4j.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: Joel Soderstrom (joel[at]frostdigital[dot]se)
 * Date: 2012-04-22
 * Time: 4:20 PM
 */
public class TrelloTypeTest {

    @Test
    public void testFromString_shouldCreateOrganization() throws Exception {
        final String type = "organization";
        assertEquals(TrelloType.ORGANIZATION, TrelloType.fromString(type));
    }

    @Test
    public void testFromString_shouldCreateUnknown() throws Exception {
        final String type = "foobar";
        assertEquals(TrelloType.UNKNOWN, TrelloType.fromString(type));
    }
}

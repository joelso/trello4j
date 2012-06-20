package org.trello4j;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.trello4j.model.Board;
import org.trello4j.model.Checklist;
import org.trello4j.model.TrelloType;
import org.trello4j.model.Type;

import com.google.gson.reflect.TypeToken;


/**
 * The Class TrelloObjectFactoryImplTest.
 */
public class TrelloObjectFactoryImplTest {
	
	/** The trello obj factory. */
	TrelloObjectFactoryImpl trelloObjFactory = new TrelloObjectFactoryImpl();
	
	/**
	 * Should create board list.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void shouldCreateBoardList() throws Exception {
		// GIVEN
		InputStream json = getTestDataFromFile("boards.json");
		
		// WHEN
		List<Board> boards = trelloObjFactory.createObject(new TypeToken<List<Board>>(){}, json);
		
		// THEN
		assertEquals(5, boards.size());
		
		json.close();
	}

    /**
     * Should return empty list.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldReturnEmptyList() throws Exception {
        // GIVEN
        InputStream json = null;

        // WHEN
        List<Board> boards = trelloObjFactory.createObject(new TypeToken<List<Board>>(){}, json);

        // THEN
        assertEquals("Should return empty list", 0, boards.size());
    }


	/**
	 * Should create board.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void shouldCreateBoard() throws Exception {
		// GIVEN
		InputStream json = getTestDataFromFile("board.json");
		
		// WHEN
		Board board = trelloObjFactory.createObject(new TypeToken<Board>(){}, json);
		
		// THEN
		assertEquals("4da855081418d090420f12d7", board.getId());
		
		json.close();
	}

    /**
     * Should create checklist.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldCreateChecklist() throws Exception {
        // GIVEN
        InputStream json = getTestDataFromFile("checklist.json");

        // WHEN
        Checklist checklist = trelloObjFactory.createObject(new TypeToken<Checklist>(){}, json);

        // THEN
        assertEquals("4f92b89ea73738db6cdd4ed7", checklist.getId());
        assertEquals("Checklist", checklist.getName());
        assertEquals("4f92b80ba73738db6cdd4309", checklist.getIdBoard());
        assertEquals(3, checklist.getCheckItems().size());

        Checklist.CheckItem firstCheckItem = checklist.getCheckItems().get(0);
        assertEquals("First checkitem", firstCheckItem.getName());
        assertEquals("check", firstCheckItem.getType());
        assertEquals(8588, firstCheckItem.getPos(), 0);

        json.close();
    }

    /**
     * Should create type.
     *
     * @throws Exception the exception
     */
    @Test
    public void shouldCreateType() throws Exception {
        // GIVEN
        InputStream json = getTestDataFromFile("type.json");

        // WHEN
        Type type = trelloObjFactory.createObject(new TypeToken<Type>(){}, json);

        // THEN
        assertEquals(TrelloType.ORGANIZATION, type.getType());

        json.close();
    }


	
	/**
	 * Gets the test data from file.
	 *
	 * @param file the file
	 * @return the test data from file
	 */
	private InputStream getTestDataFromFile(String file) {
		return this.getClass().getClassLoader().getResourceAsStream(file);
	}
	
}

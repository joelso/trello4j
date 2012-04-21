package org.trello4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.trello4j.model.Board;

import com.google.gson.reflect.TypeToken;
import org.trello4j.model.Checklist;

public class TrelloObjectFactoryImplTest {
	
	TrelloObjectFactoryImpl trelloObjFactory = new TrelloObjectFactoryImpl();
	
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

    @Test
    public void shouldReturnEmptyList() throws Exception {
        // GIVEN
        InputStream json = null;

        // WHEN
        List<Board> boards = trelloObjFactory.createObject(new TypeToken<List<Board>>(){}, json);

        // THEN
        assertEquals("Should return empty list", 0, boards.size());
    }


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



	
	private InputStream getTestDataFromFile(String file) {
		return this.getClass().getClassLoader().getResourceAsStream(file);
	}
	
}

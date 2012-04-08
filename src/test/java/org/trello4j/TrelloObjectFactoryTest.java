package org.trello4j;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.trello4j.model.Board;

import com.google.gson.reflect.TypeToken;

public class TrelloObjectFactoryTest {
	
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
	public void shouldCreateBoard() throws Exception {
		// GIVEN
		InputStream json = getTestDataFromFile("board.json");
		
		// WHEN
		Board board = trelloObjFactory.createObject(new TypeToken<Board>(){}, json);
		
		// THEN
		assertEquals("4da855081418d090420f12d7", board.getId());
		
		json.close();
	}

	
	private InputStream getTestDataFromFile(String file) {
		return this.getClass().getClassLoader().getResourceAsStream(file);
	}
	
}

package org.trello4j;

import org.trello4j.model.Card;


/**
 * 
 * @author joel
 * 
 */
public interface CardService {
	
	Card getCard(String cardId);
	
}
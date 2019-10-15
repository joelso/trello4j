package org.trello4j;

import org.trello4j.model.Label;

/**
 * The Interface LabelService.
 *
 * @author joel
 */
public interface LabelService {

	/**
	 * Gets the label.
	 *
	 * @param labelId
	 *            the label id
	 * @return the label
	 */
	Label getLabel(String labelId);
/**
 * Create a new label
 * @param name
 * @param boardId
 * @param color (optionnal)
 * @return
 */
	Label createLabel(String name, String boardId, String color);
}
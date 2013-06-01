package org.trello4j.core;

import org.trello4j.model.Member;
import org.trello4j.model.Token;

public interface TokenOperations {

	Token get(String... filter);

	Member getMember(String... filter);
}

package org.trello4j.core;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.trello4j.TrelloException;
import org.trello4j.TrelloURL;

class TrelloAccessor {

	private final String apiKey;
	private final String token;

	private final RestTemplate restTemplate;

	TrelloAccessor(String apiKey, String token) {
		if (apiKey == null) {
			throw new TrelloException("API key must be set, get one here: https://trello.com/1/appKey/generate");
		}

		this.apiKey = apiKey;
		this.token = token;
		this.restTemplate = new RestTemplate();
	}

	<T> T doGet(Class<T> responseType, String urlTemplate, String param, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).filter(filters).token(token).build();
		try {
			return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType).getBody();
		} catch (Exception e) {
			return null;
		}
	}

	<T> T doGet(ParameterizedTypeReference<T> typeReference, String urlTemplate, String param, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).filter(filters).token(token).build();
		try {
			return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, typeReference).getBody();
		} catch (Exception e) {
			return null;
		}
	}
}

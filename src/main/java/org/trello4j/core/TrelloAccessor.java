package org.trello4j.core;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.trello4j.TrelloException;
import org.trello4j.TrelloURL;

//TODO Remove class and move methods to TrelloTemplate
class TrelloAccessor {

	// TODO: Reduce scope after refactoring
	public final String apiKey;
	public final String accessToken;
	private final RestTemplate restTemplate;

	TrelloAccessor(String apiKey, String accessToken) {
		if (apiKey == null) {
			throw new TrelloException("API key must be set, get one here: https://trello.com/1/appKey/generate");
		}

		this.apiKey = apiKey;
		this.accessToken = accessToken;
		this.restTemplate = new RestTemplate();
	}

	<T> T doGet(Class<T> responseType, String urlTemplate, String param, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).filter(filters).token(accessToken).build();
		try {
			return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	<T> T doGet(ParameterizedTypeReference<T> typeReference, String urlTemplate, String param, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).filter(filters).token(accessToken).build();
		try {
			return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, typeReference).getBody();
		} catch (Exception e) {
			System.out.println(url);
			e.printStackTrace();
			return null;
		}
	}

	<T> T doPost(Class<T> responseType, String urlTemplate, String param, Map<String, ?> data, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).token(accessToken).filter(filters).build();
		try {
			return restTemplate.exchange(url, HttpMethod.POST, HttpEntity.EMPTY, responseType, data).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	<T> T doPost(ParameterizedTypeReference<T> typeReference, String urlTemplate, String param, Map<String, ?> data, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).token(accessToken).filter(filters).build();
		try {
			return restTemplate.exchange(url, HttpMethod.POST, HttpEntity.EMPTY, typeReference, data).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	void doPost(String urlTemplate, String param, Map<String, ?> data, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).token(accessToken).filter(filters).build();
		try {
			// restTemplate.poexchange(url, HttpMethod.POST, HttpEntity.EMPTY,
			// typeReference, data).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Deprecated
	<T> T doPut(Class<T> responseType, String urlTemplate, String param, Map<String, ?> data, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).token(accessToken).filter(filters).build();
		try {
			return restTemplate.exchange(url, HttpMethod.PUT, HttpEntity.EMPTY, responseType, data).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	<T> T doPut(String uri, Map<String, ?> data, Class<T> responseType) {
		System.out.println(uri);
		try {
			return restTemplate.exchange(uri, HttpMethod.PUT, HttpEntity.EMPTY, responseType, data).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Deprecated
	<T> T doPut(ParameterizedTypeReference<T> typeReference, String urlTemplate, String param, Map<String, ?> data, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).token(accessToken).filter(filters).build();
		try {
			return restTemplate.exchange(url, HttpMethod.PUT, HttpEntity.EMPTY, typeReference, data).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Deprecated
	boolean doDelete(String urlTemplate, String param, String... filters) {
		final String url = TrelloURL.create(apiKey, urlTemplate, param).token(accessToken).filter(filters).build();
		try {
			restTemplate.delete(url);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	boolean doDelete(String uri) {
		try {
			restTemplate.delete(uri);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TrelloURL createTrelloUri(String uriTemplate, String... resources) {
		return new TrelloURL(apiKey, accessToken, uriTemplate, resources);
	}
}

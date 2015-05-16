package org.trello4j.core;

import java.net.URI;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.trello4j.TrelloException;
import org.trello4j.TrelloURI;

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

	<T> T doGet(String uri, Class<T> responseType) {
		try {
			return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, responseType).getBody();
		} catch (Exception e) {
			return null;
		}
	}

	<T> T doGet(String uri, ParameterizedTypeReference<T> typeReference) {
		try {
			return restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, typeReference).getBody();
		} catch (Exception e) {
			return null;
		}
	}

	boolean doPost(String uri, Map<String, ?> data) {
		try {
			restTemplate.exchange(buildUri(uri, data), HttpMethod.POST, HttpEntity.EMPTY, Object.class).getBody();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	<T> T doPost(String uri, Map<String, ?> data, Class<T> responseType) {
		try {
			return restTemplate.exchange(buildUri(uri, data), HttpMethod.POST, HttpEntity.EMPTY, responseType).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	<T> T doPost(String uri, Map<String, ?> data, ParameterizedTypeReference<T> typeReference) {
		try {
			return restTemplate.exchange(uri, HttpMethod.POST, HttpEntity.EMPTY, typeReference, data).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	boolean doPut(String uri, Map<String, ?> data) {
		try {
			restTemplate.exchange(buildUri(uri, data), HttpMethod.PUT, HttpEntity.EMPTY, Object.class).getBody();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	<T> T doPut(String uri, Map<String, ?> data, Class<T> responseType) {
		try {
			return restTemplate.exchange(buildUri(uri, data), HttpMethod.PUT, HttpEntity.EMPTY, responseType).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	<T> T doPut(String uri, Map<String, ?> data, ParameterizedTypeReference<T> typeReference) {
		try {
			return restTemplate.exchange(buildUri(uri, data), HttpMethod.PUT, HttpEntity.EMPTY, typeReference).getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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

	public TrelloURI createTrelloUri(String uriTemplate, String... resources) {
		return new TrelloURI(apiKey, accessToken, uriTemplate, resources);
	}

	private static URI buildUri(String uri, Map<String, ?> params) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		for (Map.Entry<String, ?> entry : params.entrySet()) {
			builder = builder.queryParam(entry.getKey(), entry.getValue());
		}

		return builder.build().encode().toUri();
	}
}

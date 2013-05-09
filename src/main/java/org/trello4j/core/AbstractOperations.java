package org.trello4j.core;

import static java.lang.String.format;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;

import org.trello4j.Response;
import org.trello4j.TrelloException;
import org.trello4j.TrelloObjectFactoryImpl;
import org.trello4j.TrelloUtil;

abstract class AbstractOperations {

    private static final String METHOD_DELETE   = "DELETE";
    private static final String METHOD_GET      = "GET";
    private static final String METHOD_POST     = "POST";
    private static final String METHOD_PUT      = "PUT";
	private static final String GZIP_ENCODING   = "gzip";
	
	String apiKey;
	String token;
	TrelloObjectFactoryImpl trelloObjFactory;
	
	AbstractOperations(String apiKey, String token, TrelloObjectFactoryImpl trelloObjFactory) {
		this.apiKey = apiKey;
		this.token = token;
		this.trelloObjFactory = trelloObjFactory;
	}
	
	InputStream doGet(String url) {
		return doRequest(url, METHOD_GET);
	}

	InputStream doPut(String url) {
		return doRequest(url, METHOD_PUT);
	}

	InputStream doPost(String url, Map<String, Object> map) {
		return doRequest(url, METHOD_POST, map).getInputStream();
	}

	Response doPostWithResponse(String url, Map<String, Object> map) {
		return doRequest(url, METHOD_POST, map);
	}

	Response doDelete(String url) {
		return doRequest(url, METHOD_DELETE, null);
	}

	private InputStream doRequest(String url, String requestMethod) {
        final Response response = doRequest(url, requestMethod, null);
        return response != null ? response.getInputStream() : null;
	}

	/**
	 * Execute a POST request with URL-encoded key-value parameter pairs.
	 * For a POST having an attachment, multipart/form-data will be used.
	 *
	 * @param url Trello API URL.
	 * @param map Key-value map.
	 * @return the response input stream.
	 */
	private Response doRequest(String url, String requestMethod, Map<String, Object> map) {
		try {
			HttpsURLConnection conn = (HttpsURLConnection) new URL(url)
					.openConnection();
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.setDoOutput(requestMethod.equals(METHOD_POST) || requestMethod.equals(METHOD_PUT));
			conn.setRequestMethod(requestMethod);

			if (map != null && !map.isEmpty()) {
				boolean bAllStringValues = true;
				for (Object value : map.values()) {
					if (!(value instanceof String)) bAllStringValues = false;
				}

				if (bAllStringValues) {
					StringBuilder sb = new StringBuilder();
					for (String key : map.keySet()) {
						sb.append(sb.length() > 0 ? "&" : "")
								.append(key)
								.append("=")
								.append(URLEncoder.encode((String) map.get(key), "UTF-8"));
					}
					conn.getOutputStream().write(sb.toString().getBytes());
					conn.getOutputStream().close();
				} else {
					// write multipart.
					final String boundary = UUID.randomUUID().toString();
					conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

					final DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());

					String[] keys = map.keySet().toArray(new String[map.keySet().size()]);
					for (int i = 0; i < keys.length; i++) {
						String key = keys[i];
						if (map.get(key) instanceof File) {
							dataOutputStream.writeBytes(format("--%s\r\n", boundary));
							dataOutputStream.writeBytes(format("content-type: %s\r\n", "application/octet-stream"));
							dataOutputStream.writeBytes(format("Content-Disposition: form-data; name=\"%s\";filename=\"%s\"\r\n", key, ((File) map.get(key)).getName()));
							dataOutputStream.writeBytes("\r\n");

							FileInputStream fileInputStream = new FileInputStream((File) map.get(key));
							int bytesAvailable = fileInputStream.available();
							int maxBufferSize = 16384;
							int bufferSize = Math.min(maxBufferSize, bytesAvailable);

							byte[] buffer = new byte[bufferSize];

							int bytesRead = fileInputStream.read(buffer, 0, bufferSize);

							while (bytesRead > 0) {
								dataOutputStream.write(buffer, 0, bufferSize);
								bytesAvailable = fileInputStream.available();
								bufferSize = Math.min(bytesAvailable, maxBufferSize);
								bytesRead = fileInputStream.read(buffer, 0, bufferSize);
							}

							dataOutputStream.writeBytes("\r\n");
							fileInputStream.close();
						} else {
							dataOutputStream.writeBytes(format("Content-Disposition: form-data; name=\"%s\"\r\n\r\n", key));
							dataOutputStream.writeBytes(format("%s\r\n\r\n", map.get(key)));
						}
						dataOutputStream.writeBytes(format("--%s%s\r\n", boundary, i == keys.length - 1 ? "--" : ""));
					}
				}
			}

            final int responseCode = conn.getResponseCode();
            if (responseCode == 404) {
                return null;
            } else if (responseCode > 399) {
                return new Response(conn.getErrorStream(), conn.getResponseMessage(), responseCode);
			} else {
				return new Response(
						getWrappedInputStream(
								conn.getInputStream(),
								GZIP_ENCODING.equalsIgnoreCase(conn.getContentEncoding())
						),
						conn.getResponseMessage(),
                        responseCode
				);
			}
		} catch (IOException e) {
			throw new TrelloException(e.getMessage());
		}
	}
	
	private InputStream getWrappedInputStream(InputStream is, boolean gzip)
			throws IOException {
		/*
		 * TODO: What about this? ---------------------- "Java clients which use
		 * java.util.zip.GZIPInputStream() and wrap it with a
		 * java.io.BufferedReader() to read streaming API data will encounter
		 * buffering on low volume streams, since GZIPInputStream's available()
		 * method is not suitable for streaming purposes. To fix this, create a
		 * subclass of GZIPInputStream() which overrides the available()
		 * method."
		 * 
		 * https://dev.twitter.com/docs/streaming-api/concepts#gzip-compression
		 */
		if (gzip) {
			return new BufferedInputStream(new GZIPInputStream(is));
		} else {
			return new BufferedInputStream(is);
		}
	}
	
	void validateObjectId(String id) {
		if (!TrelloUtil.isObjectIdValid(id)) {
			throw new TrelloException("Invalid object id: " + id);
		}
	}
	
}

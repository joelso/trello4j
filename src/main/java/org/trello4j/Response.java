package org.trello4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Johan Mynhardt
 */
public class Response {
	private final InputStream inputStream;
	private final String message;
	private final int code;

	public Response(InputStream inputStream, String message, int code) {
		this.inputStream = inputStream;
		this.message = message;
		this.code = code;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public String getResponseBody() {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			int b;
			while ((b = inputStream.read()) != -1) {
				byteArrayOutputStream.write(b);
			}
			return byteArrayOutputStream.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

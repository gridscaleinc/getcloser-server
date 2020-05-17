/**
 *
 */
package com.gridscale.mpath.websocket.message;

import java.util.HashMap;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * Message Frame
 *
 * Content-type: audio/aac
 * X-getcloser-Originator: [userid]
 * X-getcloser-Destination: /app/monologue
 * X-getcloser-Location:la,lo
 * X-getcloser-message-id:10202021010
 * X-getcloser-Entity: message
 *
 * @author gridscale
 *
 */
public class MessageFrame implements Message<byte[]> {

	private byte[] payload;

	private MessageHeaders headers = new MessageHeaders(new HashMap<String, Object>());

	@Override
	public byte[] getPayload() {
		return payload;
	}

	public void setPalyload(byte[] p) {
		payload = p;
	}

	@Override
	public MessageHeaders getHeaders() {
		return headers;
	}

	/**
	 *
	 * @param name
	 * @param value
	 */
	public void addHeader(String name, String value) {
		headers.put(name, value);
	}

	/**
	 *
	 * @param name
	 */
	public void removeHeader(String name) {
		headers.remove(name);
	}

}

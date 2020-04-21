/**
 * HelloMessage.java
 * Websocket
 * TODO クラスの説明。
 */
package com.gridscale.mpath.websocket.message;

/**
 * @author doman
 *
 */
public class HelloMessage {

	private String name;

	public HelloMessage() {
	}

	public HelloMessage(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

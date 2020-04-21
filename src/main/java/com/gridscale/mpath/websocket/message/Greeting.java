/**
 * Greeting.java
 * Websocket
 * TODO クラスの説明。
 */
package com.gridscale.mpath.websocket.message;

/**
 * @author doman
 *
 */
public class Greeting {

	private String content;

	public Greeting() {
	}

	public Greeting(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

}
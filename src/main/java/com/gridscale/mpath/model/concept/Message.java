/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public class Message {
	private long id;
	private String message;

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}

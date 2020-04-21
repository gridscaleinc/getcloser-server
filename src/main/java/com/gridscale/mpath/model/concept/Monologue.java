/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public class Monologue {

	private Attendee originator;
	private Message message;
	/**
	 * @return originator
	 */
	public Attendee getOriginator() {
		return originator;
	}
	/**
	 * @param originator セットする originator
	 */
	public void setOriginator(Attendee originator) {
		this.originator = originator;
	}

	/**
	 * @return message
	 */
	public Message getMessage() {
		return message;
	}
	/**
	 * @param message セットする message
	 */
	public void setMessage(Message message) {
		this.message = message;
	}

}

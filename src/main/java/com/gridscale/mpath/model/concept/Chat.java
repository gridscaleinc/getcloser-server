/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public class Chat {
	private Attendee originator;
	private Attendee destination;
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
	 * @return destination
	 */
	public Attendee getDestination() {
		return destination;
	}
	/**
	 * @param destination セットする destination
	 */
	public void setDestination(Attendee destination) {
		this.destination = destination;
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

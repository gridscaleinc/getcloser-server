/**
 *
 */
package com.gridscale.mpath.websocket.message;

/**
 * @author gridscale
 *
 */
public class InvalidMessageException extends RuntimeException {

	/**
	 *
	 */
	public InvalidMessageException() {
	}

	/**
	 * @param message
	 */
	public InvalidMessageException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidMessageException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidMessageException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidMessageException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

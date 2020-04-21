/**
 * PingResult.java
 * Mpath
 * TODO クラスの説明。
 */
package com.gridscale.mpath.api.data;

/**
 * @author doman
 *
 */
public class PingResult extends Result {

	private String reply;

	public PingResult(String reply) {
		super("OK");
		this.reply = reply;
	}

	/**
	 * reply
	 * String
	 *
	 * @return reply
	 */
	public String getReply() {
		return reply;
	}

	/**
	 * @param reply セットする reply
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}



}

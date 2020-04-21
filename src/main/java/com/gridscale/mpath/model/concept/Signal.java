/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public class Signal {
	private Endpoint source;
	private String description;

	/**
	 * @return source
	 */
	public Endpoint getSource() {
		return source;
	}

	/**
	 * @param source セットする source
	 */
	public void setSource(Endpoint source) {
		this.source = source;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description セットする description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}

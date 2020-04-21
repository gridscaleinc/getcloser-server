/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public enum ResourceType {

	SHOP(1),
	TAXI(2),
	PARKING(3);

	private int type;

	ResourceType(int t) {
		this.type = t;
	}

	/**
	 *
	 * @return
	 */
	public int getType() {
		return type;
	}

}

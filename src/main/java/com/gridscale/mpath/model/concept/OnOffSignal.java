/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public class OnOffSignal extends Signal {
	private boolean onoff;

	/**
	 * @return onoff
	 */
	public boolean isOnoff() {
		return onoff;
	}

	/**
	 * @param onoff セットする onoff
	 */
	public void setOnoff(boolean onoff) {
		this.onoff = onoff;
	}

}

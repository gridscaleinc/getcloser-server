/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public class GeoTopic extends Topic {
	private GeoTag tag;

	/**
	 * @return tag
	 */
	public GeoTag getTag() {
		return tag;
	}

	/**
	 * @param tag セットする tag
	 */
	public void setTag(GeoTag tag) {
		this.tag = tag;
	}

}

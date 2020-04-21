/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public enum ImageType {

	GIF(1),
	PNG(2),
	JPEG(3);

	private int type;
	ImageType(int t) {
		type = t;
	}

	/**
	 *
	 * @return
	 */
	public int getType() {
		return type;
	}
}

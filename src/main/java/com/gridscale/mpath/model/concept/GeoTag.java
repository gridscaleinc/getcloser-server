/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * GEO TAG.
 *
 * 地球を一定のレベルでメッシュで分割したとき、そのブロックを代表する場所の
 * 地理情報を示す。
 *
 * @author doman
 *
 */
public class GeoTag extends GeoCode{
	private GeoTagLevel level;

	/**
	 * @return level
	 */
	public GeoTagLevel getLevel() {
		return level;
	}

	/**
	 * @param level セットする level
	 */
	public void setLevel(GeoTagLevel level) {
		this.level = level;
	}


}

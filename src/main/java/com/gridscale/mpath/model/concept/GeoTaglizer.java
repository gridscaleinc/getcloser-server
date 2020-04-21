/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public interface GeoTaglizer {

	/**
	 * Leveに応じて、相応するTagを生成する。
	 *
	 * @param level
	 * @param code
	 * @return
	 */
	GeoTag  tag(GeoTagLevel level, GeoCode code);
}

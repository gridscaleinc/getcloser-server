/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public enum GeoTagLevel {
	Level1(1),
	Level2(2),
	Level3(3),
	Level4(4),
	Level5(5),
	Level6(6),
	Level7(7),
	Level8(8),
	Level9(9),
	Level10(10);

	private int level ;

	/**
	 * コンストラクタ
	 *
	 * @param l
	 */
	GeoTagLevel(int l) {
		level = l;
	}

	/**
	 *
	 * @return
	 */
	public int getLevel() {
		return level;
	}
}

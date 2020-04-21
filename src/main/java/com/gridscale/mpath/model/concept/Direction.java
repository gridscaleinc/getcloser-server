/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public class Direction {

	private double holizon;
	private double vertical;

	
	/**
	 * @param holizon セットする holizon
	 */
	public void setHolizon(double holizon) {
		this.holizon = holizon;
	}

	/**
	 * @param vertical セットする vertical
	 */
	public void setVertical(double vertical) {
		this.vertical = vertical;
	}

	/**
	 * 水平方向（0～360°)。
	 *
	 * 0を右、90は前、180は左、270は後ろ、360右
	 *
	 * @return
	 */
	public double getHolizon() {
		return holizon;
	}

	/**
	 * 垂直の度数（0～180°）。
	 *
	 * 0は水平、90は水平に垂直、180は
	 *
	 * @return
	 */
	public double getVertical() {
		return vertical;
	}
}

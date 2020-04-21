/**
 *
 */
package com.gridscale.mpath.model.concept;

import java.io.Serializable;

/**
 * @author doman
 *
 */
public class GeoCode implements Serializable{

	private double latitude;
	private double longitude;

	/**
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude セットする latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude セットする longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


}

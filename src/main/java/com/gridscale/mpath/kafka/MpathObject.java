/**
 *
 */
package com.gridscale.mpath.kafka;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gridscale
 *
 */
public class MpathObject {

	private byte[] rawdata = new byte[] {};

	private Map<String, String> headers = new HashMap<>();

	/**
	 *
	 * @param rawdata
	 */
	public MpathObject(byte[] rawdata) {
		super();
		this.rawdata = rawdata;
	}

	/**
	 *
	 */
	public MpathObject() {

	}

	/**
	 * @return rawdata
	 */
	public byte[] getRawdata() {
		return rawdata;
	}

	/**
	 * @param rawdata セットする rawdata
	 */
	public void setRawdata(byte[] rawdata) {
		this.rawdata = rawdata;
	}

	/**
	 * @return mimeType
	 */
	public String getContentType() {
		return getHeader("content-type");
	}

	/**
	 * @param mimeType セットする mimeType
	 */
	public void setContentType(String mimeType) {
		addHeader("content-type", mimeType);
	}


	/**
	 * @return headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * @param headers セットする headers
	 */
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	/**
	 *
	 * @param k
	 * @param v
	 */
	public void addHeader(String k, String v) {
		headers.put(k,v);
	}

	public void removeHeader(String k) {
		headers.remove(k);
	}

	public String getHeader(String k) {
		return headers.get(k);
	}
}

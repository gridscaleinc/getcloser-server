/**
 *
 */
package com.gridscale.mpath.model.concept;

/**
 * @author doman
 *
 */
public class VoiceMessage extends Message {
	private byte[] voiceData;
	private EncodeType encodeType;


	/**
	 * @return voiceData
	 */
	public byte[] getVoiceData() {
		return voiceData;
	}
	/**
	 * @param voiceData セットする voiceData
	 */
	public void setVoiceData(byte[] voiceData) {
		this.voiceData = voiceData;
	}
	/**
	 * @return encodeType
	 */
	public EncodeType getEncodeType() {
		return encodeType;
	}
	/**
	 * @param encodeType セットする encodeType
	 */
	public void setEncodeType(EncodeType encodeType) {
		this.encodeType = encodeType;
	}


}

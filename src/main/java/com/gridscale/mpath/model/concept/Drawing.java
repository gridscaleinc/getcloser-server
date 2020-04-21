/**
 *
 */
package com.gridscale.mpath.model.concept;/**
 * @author doman
 *
 */
public class Drawing extends WritingDown {
	private byte[] image;
	private ImageType type;
	/**
	 * @return image
	 */
	public byte[] getImage() {
		return image;
	}
	/**
	 * @param image セットする image
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	/**
	 * @return type
	 */
	public ImageType getType() {
		return type;
	}
	/**
	 * @param type セットする type
	 */
	public void setType(ImageType type) {
		this.type = type;
	}


}

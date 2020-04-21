/**
 *
 */
package com.gridscale.mpath.model.concept;


/**
 * @author doman
 *
 */
public class Resource extends Endpoint {
	private long id;
	private ResourceType type;
	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return type
	 */
	public ResourceType getType() {
		return type;
	}
	/**
	 * @param type セットする type
	 */
	public void setType(ResourceType type) {
		this.type = type;
	}


}

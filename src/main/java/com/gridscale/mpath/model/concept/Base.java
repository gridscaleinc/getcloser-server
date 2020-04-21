/**
 *
 */
package com.gridscale.mpath.model.concept;

import java.util.List;

/**
 * @author doman
 *
 */
public class Base extends Endpoint {

	private String name;
	private Attendee owner;
	private List<BaseService> services;

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return owner
	 */
	public Attendee getOwner() {
		return owner;
	}
	/**
	 * @param owner セットする owner
	 */
	public void setOwner(Attendee owner) {
		this.owner = owner;
	}
	/**
	 * @return services
	 */
	public List<BaseService> getServices() {
		return services;
	}
	/**
	 * @param services セットする services
	 */
	public void setServices(List<BaseService> services) {
		this.services = services;
	}

}

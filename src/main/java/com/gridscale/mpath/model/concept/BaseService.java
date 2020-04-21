/**
 *
 */
package com.gridscale.mpath.model.concept;

import java.util.List;

/**
 * @author doman
 *
 */
public class BaseService {

	private String name;
	private ServiceLink link;
	private List<Resource> resources;
	private String description;
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
	 * @return link
	 */
	public ServiceLink getLink() {
		return link;
	}
	/**
	 * @param link セットする link
	 */
	public void setLink(ServiceLink link) {
		this.link = link;
	}
	/**
	 * @return resources
	 */
	public List<Resource> getResources() {
		return resources;
	}
	/**
	 * @param resources セットする resources
	 */
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description セットする description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}

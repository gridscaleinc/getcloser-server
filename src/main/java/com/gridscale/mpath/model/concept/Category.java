/**
 *
 */
package com.gridscale.mpath.model.concept;

import java.io.Serializable;
import java.util.List;

/**
 * カテゴリ
 *
 * システムに定義済みの単語。
 * IDによってユニークに識別される。
 *
 * @author doman
 *
 */
public class Category implements Serializable{
	private long id;
	private Category parent;
	private List<Category> children;

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
	 * @return parent
	 */
	public Category getParent() {
		return parent;
	}
	/**
	 * @param parent セットする parent
	 */
	public void setParent(Category parent) {
		this.parent = parent;
	}
	/**
	 * @return children
	 */
	public List<Category> getChildren() {
		return children;
	}
	/**
	 * @param children セットする children
	 */
	public void setChildren(List<Category> children) {
		this.children = children;
	}

}

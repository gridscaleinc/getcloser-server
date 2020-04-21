/**
 *
 */
package com.gridscale.mpath.model.concept;

import java.util.List;

/**
 * @author doman
 *
 */
public interface Categorizer {
	List<Category> categorize(String words);
}

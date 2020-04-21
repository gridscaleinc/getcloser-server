/**
 *
 */
package com.gridscale.mpath.model.concept;

import java.util.List;

/**
 * @author doman
 *
 */
public interface Audience {

	/**
	 * 複数のListenerを表す。
	 *
	 * @return
	 */
	List<Attendee> getListeners();
}

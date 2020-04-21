/**
 * LcationPageController.java
 * Mpath
 * TODO クラスの説明。
 */
package com.gridscale.mpath.webapp.landing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author doman
 *
 */
@Controller
public class LcationPageController {
	@GetMapping("/locate")
	public String locate(Model model) {

		return "location";

	}

}

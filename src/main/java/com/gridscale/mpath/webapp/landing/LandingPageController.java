/**
 * LandingPageController.java
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
public class LandingPageController {

	@GetMapping("/")
	public String top(Model model) {

		return "landing";
	}

}

class ViewData {
    private int no;
    private String message;
    private String picture;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}

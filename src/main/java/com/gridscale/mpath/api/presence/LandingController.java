/**
 * LandingController.java
 * Mpath
 * TODO クラスの説明。
 */
package com.gridscale.mpath.api.presence;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.gridscale.mpath.api.data.PingResult;
import com.gridscale.mpath.api.data.Request;
import com.gridscale.mpath.api.data.Result;

/**
 * @author doman
 *
 */
@RestController
public class LandingController {

	/**
	 *
	 * TODO 説明を書く。
	 *
	 * @param req
	 * @return
	 */
	@PostMapping(path="/api/{version}/landing")
	public Result land(Request req) {

		return Result.OK;

	}

	/**
	 *
	 * TODO 説明を書く。
	 *
	 * @param req
	 * @return
	 */
	@GetMapping(path="/api/{version}/landing")
	public Result test(Request req, @PathVariable("version") String version,@RequestHeader Map<String, String> headers) {
		String headString ="";
		for (String key : headers.keySet()) {
			headString += key + ":" + headers.get(key);
		}
		return new PingResult("Think your are testing api landing controller, result:OK, api version: " + version + ", headers: " + headString  );


	}

}

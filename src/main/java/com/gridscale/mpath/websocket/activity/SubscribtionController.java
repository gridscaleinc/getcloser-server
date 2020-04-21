/**
 * SubscribtionController.java
 * Mpath
 * TODO クラスの説明。
 */
package com.gridscale.mpath.websocket.activity;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

/**
 * @author doman
 *
 */
@Controller
public class SubscribtionController implements ApplicationListener<SessionSubscribeEvent> {


	@SubscribeMapping("/geotag/1")
	public void toGeoTag () {
		System.out.println("Hi");
	}

	@Override
	public void onApplicationEvent(SessionSubscribeEvent event) {
		System.out.println(event);

	}

}

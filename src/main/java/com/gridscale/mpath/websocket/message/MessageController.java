/**
 * MessageController.java
 * Websocket
 * TODO クラスの説明。
 */
package com.gridscale.mpath.websocket.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * @author doman
 *
 */
@Controller
public class MessageController {

	@Autowired
	private KafkaTemplate<String, String> template;

	@MessageMapping("/hello")
	public void greeting(HelloMessage message, StompHeaderAccessor accessor) throws Exception {
		this.template.send("geotag", message.getName());
	}

}
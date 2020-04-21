/**
 * KafkaHandler.java
 * Mpath
 * TODO クラスの説明。
 */
package com.gridscale.mpath.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import com.gridscale.mpath.websocket.message.Greeting;

/**
 * @author doman
 *
 */
@Component
@KafkaListener(id = "getcloser", topics = {"geotag"})
public class GeoMessageHandler {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@KafkaHandler
	public void geoMessage(String talk) {
		Greeting g = new Greeting(talk);
		messagingTemplate.convertAndSend( "/app/geotag/1", g );
		messagingTemplate.convertAndSend( "/app/geotag/1/2",  g);
		messagingTemplate.convertAndSend( "/app/geotag/1/2/3",  g);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			;
		}
	}
}
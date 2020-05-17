/**
 * KafkaHandler.java
 * Mpath
 * TODO クラスの説明。
 */
package com.gridscale.mpath.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import com.gridscale.mpath.kafka.MpathObject;

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
	public void geoMessage(MpathObject object) {

		Map<String,Object> headers = new HashMap<String,Object>();
		for (String k: object.getHeaders().keySet()) {
			if (k.equals("content-type")) {
				headers.put(k, object.getHeader(k));
			}
		}

		GenericMessage<byte[]> frame = new GenericMessage<byte[]>(object.getRawdata(), headers);
		try {
			System.out.println("payload:" + new String(object.getRawdata(), "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		System.out.println(headers);

		messagingTemplate.send("/app/geotag/1", frame);
		messagingTemplate.send("/app/geotag/1/2", frame);
		messagingTemplate.send("/app/geotag/1/2/3", frame);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			;
		}
	}
}


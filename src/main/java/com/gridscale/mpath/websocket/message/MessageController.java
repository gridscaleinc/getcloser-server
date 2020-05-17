/**
 * MessageController.java
 * Websocket
 * TODO クラスの説明。
 */
package com.gridscale.mpath.websocket.message;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Controller;

import com.gridscale.mpath.kafka.KafkaProducerRecordBuilder;
import com.gridscale.mpath.kafka.MpathObject;

/**
 * @author doman
 *
 */
@Controller
public class MessageController {

	@Autowired
	private KafkaTemplate<String, MpathObject> template;

	@MessageMapping("/hello")
	public void greeting(GenericMessage<byte[]> message, StompHeaderAccessor accessor) throws Exception {

		MpathObject obj = new MpathObject();

		obj.setRawdata(message.getPayload());
		for (String k: message.getHeaders().keySet()) {
			obj.addHeader(k, message.getHeaders().get(k).toString());
		}

		ProducerRecord<String, MpathObject> record = new KafkaProducerRecordBuilder().build("geotag", null, "hello", obj);
		record.headers();
		this.template.send( record);

	}

}
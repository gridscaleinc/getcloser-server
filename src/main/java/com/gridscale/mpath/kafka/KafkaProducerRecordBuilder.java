/**
 *
 */
package com.gridscale.mpath.kafka;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;

/**
 * @author gridscale
 *
 */
public class KafkaProducerRecordBuilder {

	/**
	 *
	 */
	public KafkaProducerRecordBuilder() {
	}

	/**
	 *
	 * @param topic
	 * @param partition
	 * @param key
	 * @param value
	 * @return
	 */
	public ProducerRecord<String, MpathObject> build(String topic, Integer partition, String key, MpathObject value) {
		List<Header> recordHeaders = new ArrayList<Header>();
		Map<String, String> headers = value.getHeaders();

		for (String k: headers.keySet()) {
			String v = headers.get(k);
			try {
				recordHeaders.add(new RecordHeader(k, v.getBytes("utf-8")));
			} catch (UnsupportedEncodingException e) {
			}
		}

		ProducerRecord<String, MpathObject> record = new ProducerRecord<String, MpathObject>(topic,partition, key, value, recordHeaders);
		return record;
	}

}

/**
 *
 */
package com.gridscale.mpath.kafka;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

/**
 * @author gridscale
 *
 */
public class MpathObjectDeserializer implements Deserializer<MpathObject> {

	@Override
	public MpathObject deserialize(String topic, byte[] data) {
		MpathObject o = new MpathObject(data);
		o.setContentType("octet-stream");
		return o;
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		Deserializer.super.configure(configs, isKey);
	}

	@Override
	public MpathObject deserialize(String topic, Headers headers, byte[] data) {

		MpathObject o = new MpathObject(data);
		for (Header h: headers) {
			try {
				o.addHeader(h.key(), new String(h.value(),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
			}
		}

		return o;
	}

	@Override
	public void close() {
		Deserializer.super.close();
	}
}

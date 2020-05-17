/**
 *
 */
package com.gridscale.mpath.kafka;

import org.apache.kafka.common.serialization.Serializer;

/**
 * @author gridscale
 *
 */
public class MpathObjectSerializer implements Serializer<MpathObject> {

	/**
	 *
	 */
	public MpathObjectSerializer() {
	}

	@Override
	public byte[] serialize(String topic, MpathObject data) {
		return data.getRawdata();
	}

}

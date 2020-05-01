/**
 * WebSocketConfig.java
 * Mpath
 *
 * TODO クラスの説明。
 */
package com.gridscale.mpath;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author doman
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	/**
	 *
	 */
	public static String TOPIC_GEOTAG = "/app/geotag";

	/**
	 *
	 */
	public static String TOPIC_WATCHLIST = "/app/watchlist";

	/**
	 *
	 */
	public static String TOPIC_WISHLIST = "/app/wishlist";

	/**
	 *
	 */
	public static String TOPIC_OFFER = "/app/offer";

	/**
	 * TPICSを定義
	 */
	public static final String[] TOPIC_LIST = {
			TOPIC_GEOTAG,
			TOPIC_WATCHLIST,
			TOPIC_WISHLIST,
			TOPIC_OFFER
	};

	/**
	 *
	 */
	public static String WEBSOCKET_CONTEXT_APP = "/app";

	/**
	 *
	 */
	public static String WEBSOCKET_CONTEXT_MANAGEMENT = "/mgm";


	/**
	 * websocket context定義。
	 */
	public static final String[] APPLICATION_LIST = {
			WEBSOCKET_CONTEXT_APP,
			WEBSOCKET_CONTEXT_MANAGEMENT
	};

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker(TOPIC_GEOTAG);
		config.setApplicationDestinationPrefixes(WEBSOCKET_CONTEXT_APP);
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		registry.addEndpoint("/endpoint-getcloser").withSockJS();
		registry.addEndpoint("/endpoint-getcloser").setAllowedOrigins("*");
	}
}
/**
 * WebConfig.java
 * Mpath
 * TODO クラスの説明。
 */
package com.gridscale.mpath.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author doman
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO
		WebMvcConfigurer.super.configurePathMatch(configurer);

		System.out.println("WebConfig");
	}
    // ...

}
package com.gridscale.mpath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MpathApplication {
	public static ApplicationContext appcontext = null;
	public static void main(String[] args) {
		appcontext = SpringApplication.run(MpathApplication.class, args);

	}
}

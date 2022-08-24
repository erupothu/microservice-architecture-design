package com.tutorial.authserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

	private static final String HTTP_LOCALHOST_4200 = "http://localhost:4200";
	private static final String GET = "GET";
	private static final String POST = "POST";
	private static final String PUT = "PUT";
	private static final String DELETE = "DELETE";
	private static final String HEAD = "HEAD";

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOrigins(HTTP_LOCALHOST_4200).allowedMethods(GET, POST, PUT, DELETE, HEAD)
				.allowCredentials(true);
	}
}

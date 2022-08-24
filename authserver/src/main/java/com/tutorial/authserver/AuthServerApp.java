package com.tutorial.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableAuthorizationServer
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "User API", version = "2.0", description = "User Information"))
public class AuthServerApp {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApp.class, args);
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//			}
//		};
//	}
	
//	@Bean
//	public CorsFilter corsFilter() {
//	    CorsConfiguration config = new CorsConfiguration();
//	    config.addAllowedOrigin("*");
//	    config.addAllowedHeader("*");
//	    config.setAllowedMethods(Arrays.asList("OPTIONS", "GET", "POST"));
//
//	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    source.registerCorsConfiguration("/**", config);
//
//	    return new CorsFilter(source);
//	}

}

//package com.tutorial.authserver.config;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
// 
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.cors().and();
//      //other config
//  }
// 
//  @Bean
//  CorsConfigurationSource corsConfigurationSource() 
//  {
//    org.springframework.web.cors.CorsConfiguration configuration = new org.springframework.web.cors.CorsConfiguration();
//    configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
//    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", configuration);
//    return source;
//  }
//}

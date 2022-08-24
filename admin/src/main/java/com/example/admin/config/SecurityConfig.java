package com.example.admin.config;

import java.util.UUID;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AdminServerProperties adminServer;
    private SecurityProperties security;
    public SecurityConfig(AdminServerProperties adminServer, SecurityProperties security) {
       this.adminServer = adminServer;
       this.security = security;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
       successHandler.setTargetUrlParameter("redirectTo");
       successHandler.setDefaultTargetUrl(this.adminServer.path("/"));
       http.authorizeRequests(
          (authorizeRequests) -> authorizeRequests.antMatchers(this.adminServer.path("/assets/**")).permitAll()
          .antMatchers(this.adminServer.path("/actuator/info")).permitAll()
          .antMatchers(this.adminServer.path("/actuator/health")).permitAll()
          .antMatchers(this.adminServer.path("/login")).permitAll().anyRequest().authenticated()
       ).formLogin(
          (formLogin) -> formLogin.loginPage(this.adminServer.path("/login")).successHandler(successHandler).and()
          ).logout((logout) -> logout.logoutUrl(this.adminServer.path("/logout"))).httpBasic(Customizer.withDefaults())
          .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
             .ignoringRequestMatchers(
                new AntPathRequestMatcher(this.adminServer.path("/instances"),
                   HttpMethod.POST.toString()),
                new AntPathRequestMatcher(this.adminServer.path("/instances/*"),
                   HttpMethod.DELETE.toString()),
                new AntPathRequestMatcher(this.adminServer.path("/actuator/**"))
             ))
          .rememberMe((rememberMe) -> rememberMe.key(UUID.randomUUID().toString()).tokenValiditySeconds(1209600));
       }
    
    
}

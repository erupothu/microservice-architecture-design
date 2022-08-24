package com.example.sslsecurity.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // Configure WEB Security
    // @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/welcome", "/ignore2");
    }

    // Configure HTTP Security
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.authorizeRequests()
    //       .antMatchers("/**")
    //       .permitAll(); 
    // }

    // In Memory Authentication
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //         .username("user")
    //         .password("user")
    //         .roles("USER")
    //         .build();
    //     auth.inMemoryAuthentication()
    //         .withUser(user);
    // }

    // JDBC Authentication
    // @Bean
    // public DataSource dataSource() {
    //     return new EmbeddedDatabaseBuilder()
    //         .setType(EmbeddedDatabaseType.H2)
    //         .build();
    // }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //         .username("user")
    //         .password("password")
    //         .roles("USER")
    //         .build();
    //     auth.jdbcAuthentication()
    //         .withDefaultSchema()
    //         .dataSource(dataSource())
    //         .withUser(user);
    // }

    // LDAP Authentication
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth
    //         .ldapAuthentication()
    //         .userDetailsContextMapper(new PersonContextMapper())
    //         .userDnPatterns("uid={0},ou=people")
    //         .contextSource()
    //         .port(0);
    // }

}
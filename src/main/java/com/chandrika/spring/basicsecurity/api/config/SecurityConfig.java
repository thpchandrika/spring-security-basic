package com.chandrika.spring.basicsecurity.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    //using NoOpPasswordEncoder
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin")
//                .password("admin")
//                .roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("user")
//                .password("user")
//                .roles("USER");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER");
    }


//    //deprecated NoOpPasswordEncoder. Use BCryptPasswordEncoder/Argon2PasswordEncoder/Pbkdf2PasswordEncoder
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    //security for all APIs
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests()
//                .anyRequest()
//                .fullyAuthenticated()
//                .and()
//                .httpBasic();
//    }

//      //security based on URL
//      @Override protected void configure(HttpSecurity http) throws Exception {
//          http.csrf().disable();
//          http.authorizeRequests()
//                  .antMatchers("/rest/**")
//                  .fullyAuthenticated()
//                  .and()
//                  .httpBasic();
//      }

    // security based on ROLE
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/rest/**")
                .hasAnyRole("ADMIN")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();
    }

}

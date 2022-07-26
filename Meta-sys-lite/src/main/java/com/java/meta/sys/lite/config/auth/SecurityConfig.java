package com.java.meta.sys.lite.config.auth;


import com.java.meta.sys.lite.common.exception.AuthAccountException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author HY
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {

        try {
            return httpSecurity.build();
        } catch (Exception e) {
            throw new AuthAccountException(e.getMessage());
        }
    }
}

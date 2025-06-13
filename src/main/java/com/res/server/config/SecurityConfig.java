package com.res.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.cors(Customizer.withDefaults());
        security.csrf(AbstractHttpConfigurer::disable);

        security.authorizeRequests(authZ -> 
            authZ.antMatchers("/api/v1/**").authenticated() // ✅ FIXED
                 .anyRequest().permitAll()
        );

        security.oauth2ResourceServer(authServer -> authServer.jwt(Customizer.withDefaults()));
        return security.build();
    }
}

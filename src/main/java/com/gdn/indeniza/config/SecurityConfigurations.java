package com.gdn.indeniza.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
    	
    	MvcRequestMatcher.Builder mvcResqueBuilder = new MvcRequestMatcher.Builder(introspector);
    	
		httpSecurity.csrf(
				csrf -> csrf.disable()
		)
		.sessionManagement(
				session -> session
				.sessionCreationPolicy(
						SessionCreationPolicy.STATELESS
			)
		);
		
		httpSecurity.headers(
				headersConf -> headersConf
				.frameOptions(
						HeadersConfigurer.FrameOptionsConfig::sameOrigin
			)
		);
		
		httpSecurity.authorizeHttpRequests(
				authorize -> authorize
				.requestMatchers(mvcResqueBuilder.pattern("/**"))
				.permitAll()
				.requestMatchers(PathRequest.toH2Console())
				.permitAll()
		);
		
    	return httpSecurity.build();
	} 
}

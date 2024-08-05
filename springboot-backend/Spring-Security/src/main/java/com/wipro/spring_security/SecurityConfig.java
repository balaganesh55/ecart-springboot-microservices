package com.wipro.spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	UserDetailsService getUserDetailsBean() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(User.withUsername("abc").password("abc123").roles("USER").build());
		
		manager.createUser(User.withUsername("raj").password("raj123").roles("USER").build());
		
		manager.createUser(User.withUsername("xyz").password("zyx123").roles("USER","ADMIN").build());
		
		return manager;		
	}
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		    http.csrf(AbstractHttpConfigurer::disable)
		      .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
		              authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
		                      .requestMatchers("/admin/**").hasAnyRole("ADMIN")
		                      .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
		                      .requestMatchers("/login/**").permitAll()
		                      .anyRequest().authenticated())
		      .httpBasic(Customizer.withDefaults())
		      .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	 return http.build();
	}	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return  NoOpPasswordEncoder.getInstance();
//		return new BCryptPasswordEncoder();
	}
		
}

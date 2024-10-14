package com.Arc.hospital.config;

import java.security.AuthProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Arc.hospital.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserDetailService userDetailService;
	
    @Autowired
    public SecurityConfig(CustomUserDetailService userDetailService) {
    	this.userDetailService= userDetailService;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authProvider() {
       DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       authProvider.setUserDetailsService(userDetailService);
       authProvider.setPasswordEncoder(passwordEncoder());
       return authProvider;
       
    }
    
    @Bean
    public  AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
        	   .authenticationProvider(authProvider())
        	   .build();
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		 .authorizeHttpRequests()
		 .requestMatchers("/appointment/**").hasAnyRole("ADMIN","USER")
		 .requestMatchers("/doctor/**").hasRole("ADMIN")
		 .requestMatchers("/patient/**").hasRole("USER")
		 .requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
		 .requestMatchers("/login","register").permitAll()
		 .anyRequest().authenticated()
		 .and()
		 .httpBasic()
		 .and()
		 .formLogin()
		 .loginPage("/login")
		 .permitAll()
		 .and()
		 .logout()
		 .permitAll();
		 
		 return http.build();
	}
	
	
}


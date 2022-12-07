package com.capstone.nationalparkvisits.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig {

	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {//TODO THIS NEEDS TO BE UPDATED
		http
			.csrf().disable()
	        .authorizeRequests()
	        	// this line of code specifies all URLs that do not need authentication to view
	        	.antMatchers("/", "/index", "/signup", "admin/admin", "/admin/admintest", "/signin").permitAll()
	        	// this line of code tells spring security that all URLs can only be accessed if the user
	        	// is authenticated.   This is authetnication only and does not care about authorization.
	        	// authorization must be implement in the controller to limit by user role
				.anyRequest().authenticated()
	        	.and()
	        .formLogin()
	        	// this is the URL to the login page
	        	// the request method for this is implemented in the login controller
	        	// to display the login.jsp view
	            .loginPage("/signin")
	            // this is the URL that the login page will submit to with a action="/user/login" method="POST"
	            .loginProcessingUrl("/signin")
	            // this URL is where spring security will send the user IF they have not requested a secure URL
	            // if they have requested a secure URL spring security will ignore this and send them to the 
	            // secured url they requested
	            .defaultSuccessUrl("/")
	            .and()
	        .logout()
	            .invalidateHttpSession(true)
	            // this is the URL to log a user out
	            .logoutUrl("/logout")
	            // this is the URL to send the browser to after the user has logged out
	            .logoutSuccessUrl("/index");
		
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

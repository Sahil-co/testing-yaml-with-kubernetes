package com.cg.login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cg.login.service.UserDetailsServiceImpl;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	
	@Bean
	protected UserDetailsService userDetailsService() {
		
		return new UserDetailsServiceImpl();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	 
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* Make necessary  changes in the antMatchers
		 * put the url according to user role and in 
		 * hasAuthority put the required role to access the url
		 * For Example anrMatchers("/customer/**").hasAuthority("CUSTOMER")
		 * if a url is accessible by one or more actors then use
		 * hasAnyAuthrity() instead of hasAuthority*/
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/user/**").hasAuthority("USER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/403");
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	
	}
	

}

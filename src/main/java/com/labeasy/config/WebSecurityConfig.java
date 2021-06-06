package com.labeasy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.labeasy.security.CustomLoginFailureHandler;
import com.labeasy.security.CustomLoginSuccessHandler;
import com.labeasy.services.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	private final UserService userDetailsService;
	private final CustomLoginFailureHandler loginFailureHandler;
	private final CustomLoginSuccessHandler customLoginSuccessHandler;

	@Autowired
	public WebSecurityConfig(final UserService userDetailsService, final CustomLoginFailureHandler loginFailureHandler,
			CustomLoginSuccessHandler customLoginSuccessHandler) {
		super();
		this.userDetailsService = userDetailsService;
		this.loginFailureHandler = loginFailureHandler;
		this.customLoginSuccessHandler = customLoginSuccessHandler;
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/dasboard", true)
				.successHandler(customLoginSuccessHandler)
				.failureHandler(loginFailureHandler).permitAll().and().logout().permitAll();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
}

package com.serviceauto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	// in antMatchers pot baga daca mai vreau sa securizez ceva
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin", "/serviceauto/admin/all/users", "/serviceauto/admin")
				.access("hasRole('ROLE_ADMIN')").and().authorizeRequests()
				.antMatchers("/serviceauto/user/main", "/serviceauto/user/car/defection/{carId}")
				.access("hasRole('ROLE_USER')").anyRequest().permitAll().and().formLogin()
				.loginPage("/serviceauto/login").usernameParameter("username").passwordParameter("password").and()
				.logout().logoutSuccessUrl("/serviceauto/login?logout").and().exceptionHandling()
				.accessDeniedPage("/403").and().csrf();
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

}
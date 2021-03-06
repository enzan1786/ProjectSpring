package com.green.jdevd010.EShopClient.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.green.jdevd010.EShopClient.controllers.services.UserDetailsServiceImpl;
import com.green.jdevd010.EShopClient.handlers.OnAuthenticationFailureHandler;
import com.green.jdevd010.EShopClient.handlers.OnAuthenticationSuccessHandler;

@Configuration()
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	private final String password = "$2a$10$QF/YQ9BzZoPmi5of5kkNeOP0bre/XmlsxyMX61aEeKwBsSxsfv1/u";

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		System.out.println("userDetailsService *********");
		return new UserDetailsServiceImpl();
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

//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		UserDetails userAdmin = User.withUsername("admin")
//				.password(password).roles("ADMIN").build();
//		
//		UserDetails userGreen = User.withUsername("green")
//				.password(password).roles("USER").build();
//		
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		
//		manager.createUser(userAdmin);
//		manager.createUser(userGreen);
//		
//		return manager;
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/save", "/login2","/signup" ,"/login_error", "/assets/**", "/css/**", "/fonts/**", "/images/**", "/js/**",
						"/ustora/**", "/vendor/**","/Signup/**")
				.permitAll()
				.antMatchers("/product").hasRole("ADMIN")
				.antMatchers("/new_product").hasRole("ADMIN")
				.antMatchers("/update_order_status").hasAnyAuthority("saler","shipper")
				.anyRequest().authenticated()
				//.and().oauth2Login().loginPage("/login").permitAll()
				.and().formLogin()
				.loginPage("/login").permitAll()
				.usernameParameter("username")
				.passwordParameter("password")
				.loginProcessingUrl("/dologin")
				.failureHandler(new OnAuthenticationFailureHandler())
				.successHandler(new OnAuthenticationSuccessHandler())
				.and().logout().permitAll()
				.and().exceptionHandling().accessDeniedPage("/403");
	}

}

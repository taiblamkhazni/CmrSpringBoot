package com.example.demo.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.services.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final UserService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	

	public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors()// activation du cors

				.and()

				.csrf().disable() // desactivation du csrf

				// Autoriser les requêtes du client
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, SecurityConstante.SIGN_UP_URL) // Autoriser la requete post /login

						.permitAll()// tous les droit
						.antMatchers("/swagger-ui/**","/v3/api-docs/**",
								"/javainuse-openapi/**")
						.permitAll()
						.anyRequest().authenticated()// Le reste tu as obligé d'authenticated
						.and()
						.addFilter(getAuthenticationFilter())
						.addFilter(new AuthorizationFilter(authenticationManager()))//Filter pour connicter avec le token
						.sessionManagement()
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

				

	}
	
	
	protected AuthenticationFilter getAuthenticationFilter() throws Exception {
	    final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
	    filter.setFilterProcessesUrl("/users/login");
	    return filter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

}

package com.gateway.cloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtUnAuthorizedResponseAuthenticationEntryPoint jwtUnAuthorizedResponseAuthenticationEntryPoint;

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenAuthorizationOncePerRequestFilter jwtAuthenticationTokenFilter;

	@Value("${sicurezza.uri}")
	private String authenticationPath;
	
	@Autowired
	private PasswordEncoder passwordEncoderBean;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoderBean);
	}

	
	
	

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	private static final String[] NOAUTH_MATCHER = { "/api/autorizzazione/**",
			"/gateway-registrazione/api/registrazione/**", "/gateway-articoli/api/view/articoli/**",
			"/gateway-promo/api/view/promo/**", };

	private static final String[] CLIENTE_MATCHER = { "/gateway-cliente/api/cliente/**",
			"/getprice/api/listino/cerca/**", "/getprice/info", "/getart/api/articoli/cerca/**" };

	private static final String[] ESERCENTE_MATCHER = { "/gateway-articoli/api/gestione/articoli/**",
															"/gateway-commerciante/api/commerciante/**",
															"/gateway-commerciante/api/setup/commerciante/**"};

	private static final String[] ADMIN_MATCHER = { "/gateway-admin/api/admin/**", "/gateway-articoli/api/gestione/articoli/**" };

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().exceptionHandling()
				.authenticationEntryPoint(jwtUnAuthorizedResponseAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers(NOAUTH_MATCHER).permitAll() // End Point che non richiede autenticazione
				.antMatchers(CLIENTE_MATCHER).hasAnyRole("CLIENTE","ADMIN").antMatchers(ADMIN_MATCHER).hasAnyRole("ADMIN")
				.antMatchers(ESERCENTE_MATCHER).hasAnyRole("ESERCENTE","ADMIN").anyRequest().authenticated();

		httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

		httpSecurity.headers().frameOptions().sameOrigin().cacheControl();

	}

	@Override
	public void configure(WebSecurity webSecurity) {
		webSecurity.ignoring().antMatchers(HttpMethod.POST, "/**").antMatchers(HttpMethod.OPTIONS, "/**").and()
				.ignoring().antMatchers(HttpMethod.GET, "/");
	}

}

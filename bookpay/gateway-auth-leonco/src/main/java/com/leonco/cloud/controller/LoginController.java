package com.leonco.cloud.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonco.cloud.composite.UserComposite;
import com.leonco.cloud.exception.AuthenticationException;
import com.leonco.cloud.model.Utenti;
import com.leonco.cloud.security.CustomUserDetailsService;
import com.leonco.cloud.security.JwtTokenUtil;

@RestController
@RequestMapping(value = "/api/autorizzazione/")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Value("${sicurezza.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserComposite userComposite;
	
	
	@PostMapping(value = "login")
	public ResponseEntity<?> login(@RequestBody Utenti user) {

		logger.info("inizio login");

		String utJson = "";

		try {
			Utenti utenti = (Utenti) userDetailsService.loadUserByUsername(user.getEmail());

			if (utenti == null) {
				logger.info("Utente non esiste");
				return new ResponseEntity<Utenti>(HttpStatus.NOT_FOUND);
			}
			boolean checkPassword = userDetailsService.checkPassword(user.getPassword(), utenti.getPassword());

			if (!checkPassword) {
				logger.info("password sbagliata");
				return new ResponseEntity<Utenti>(HttpStatus.NOT_FOUND);
			}
			authenticate(user.getEmail(), user.getPassword());
			final String token = jwtTokenUtil.generateToken(utenti);

			logger.warn(String.format("Token %s", token));
			utenti.setToken(token);
			logger.info("fine login");
			ObjectMapper mapper = new ObjectMapper();

			utJson = mapper.writeValueAsString(utenti);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userComposite.build(utJson);

	}

	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}

	private void authenticate(String username, String password) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			logger.warn("UTENTE DISABILITATO");
			throw new AuthenticationException("UTENTE DISABILITATO", e);
		} catch (BadCredentialsException e) {
			logger.warn("CREDENZIALI NON VALIDE");
			throw new AuthenticationException("CREDENZIALI NON VALIDE", e);
		}
	}

}

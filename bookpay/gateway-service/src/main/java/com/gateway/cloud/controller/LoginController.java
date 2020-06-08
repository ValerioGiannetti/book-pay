package com.gateway.cloud.controller;

import java.util.LinkedHashSet;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gateway.cloud.composite.UserComposite;
import com.gateway.cloud.dto.ClienteDto;
import com.gateway.cloud.dto.EsercenteDto;
import com.gateway.cloud.dto.PrenotazioniDto;
import com.gateway.cloud.dto.UtenteDto;
import com.gateway.cloud.entity.DPrenotazioni;
import com.gateway.cloud.entity.DUtente;
import com.gateway.cloud.exception.AuthenticationException;
import com.gateway.cloud.security.CustomUserDetailsService;
import com.gateway.cloud.security.JwtTokenUtil;


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
	public ResponseEntity<UtenteDto> login(@RequestBody DUtente user) {

		logger.info("inizio login");

		
		UtenteDto dto = new UtenteDto();
		try {
			DUtente utenti = (DUtente) userDetailsService.loadUserByUsername(user.getEmail());

			if (utenti == null) {
				logger.info("Utente non esiste");
				return new ResponseEntity<UtenteDto>(HttpStatus.NOT_FOUND);
			}
			boolean checkPassword = userDetailsService.checkPassword(user.getPassword(), utenti.getPassword());

			if (!checkPassword) {
				logger.info("password sbagliata");
				return new ResponseEntity<UtenteDto>(HttpStatus.NOT_FOUND);
			}
			authenticate(user.getEmail(), user.getPassword());
			final String token = jwtTokenUtil.generateToken(utenti);
			
			
			dto.setToken(token);
			swapEntityDto(dto, utenti);
			
			logger.warn(String.format("Token %s", token));
			//utenti.setToken(token);
			logger.info("fine login");
//			ObjectMapper mapper = new ObjectMapper();
//
//			utJson = mapper.writeValueAsString(utenti);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return null;
		return new ResponseEntity<UtenteDto>(dto,HttpStatus.OK);

	}
	
	@PostMapping(value = "loginTest")
	public ResponseEntity<?> loginTest(@RequestParam("email")String email,
			@RequestParam("password")String password) {

		logger.info("inizio login");

		String utJson = "";

		try {
			DUtente utenti = (DUtente) userDetailsService.loadUserByUsername(email);

			if (utenti == null) {
				logger.info("Utente non esiste");
				return new ResponseEntity<DUtente>(HttpStatus.NOT_FOUND);
			}
			boolean checkPassword = userDetailsService.checkPassword(password, utenti.getPassword());

			if (!checkPassword) {
				logger.info("password sbagliata");
				return new ResponseEntity<String>("Password Sbagliata",HttpStatus.NOT_FOUND);
			}
			authenticate(email, password);
			final String token = jwtTokenUtil.generateToken(utenti);

			logger.warn(String.format("Token %s", token));
			//utenti.setToken(token);
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
	
	
	private void swapEntityDto(UtenteDto dto,DUtente dUtente) {
		
		dto.setAttivo(dUtente.getAttivo());
		dto.setEmail(dUtente.getEmail());
		dto.setNome(dUtente.getNome());
		dto.setPassword(dUtente.getPassword());
		dto.setIdUtente(String.valueOf(dUtente.getIdUtente()));
		
		if(dUtente.getEsercente() != null) {
			EsercenteDto esercenteDto = (EsercenteDto) dto;
			
			esercenteDto.setIdEsercente(String.valueOf(dUtente.getEsercente().getIdEsercente()));
			esercenteDto.setPiva(dUtente.getEsercente().getPiva());
			
		}
		if(dUtente.getCliente() != null) {
			ClienteDto clienteDto = (ClienteDto) dto;
			clienteDto.setIdClienti(String.valueOf(dUtente.getCliente().getIdClienti()));
			clienteDto.setCognome(dUtente.getCliente().getCognome());
			clienteDto.setLatitudine(dUtente.getCliente().getLatitudine());
			clienteDto.setLongitudine(dUtente.getCliente().getLongitudine());
			clienteDto.setVia(dUtente.getCliente().getVia());
			clienteDto.setCap(dUtente.getCliente().getCap());
			clienteDto.setListaPrenotazioni(new LinkedHashSet<>());
			for (DPrenotazioni dPrenotazioni : dUtente.getCliente().getDPrenotazionis()) {
				PrenotazioniDto prenotazioniDto = new PrenotazioniDto();
				
				prenotazioniDto.setIdPrenotazioni(String.valueOf( dPrenotazioni.getIdPrenotazioni()));
				prenotazioniDto.setClienteDto(clienteDto);
				prenotazioniDto.setGiorno(dPrenotazioni.getGiorno());
				prenotazioniDto.setOra(dPrenotazioni.getOra());
				prenotazioniDto.setMinuti(dPrenotazioni.getMinuti());
				
				clienteDto.getListaPrenotazioni().add(prenotazioniDto);
				
			}

		}
		
	}
	

}

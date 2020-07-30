package com.bookpay.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.dto.ClienteDto;
import com.bookpay.cloud.dto.EsercenteDto;
import com.bookpay.cloud.service.UtenteService;

@RestController
@RequestMapping(value = "/api/registrazione/")
public class RegistrazioneController {
	
	@Autowired
	private UtenteService service;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("cliente")
	public ResponseEntity<String>registrazioneCliente(@RequestBody ClienteDto clienteDto){
		
		logger.info("inizio registrazione cliente");
		
		try {
			String password = passwordEncoder.encode(clienteDto.getPassword());
			clienteDto.setPassword(password);
			service.registrazione(clienteDto);
		}catch (Exception e) {
			return new ResponseEntity<String>("Contattare l'assistenza oppure riprovare.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("fine registrazione cliente");
		return new ResponseEntity<String>("Registrazione Avvenuta con successo",HttpStatus.OK);
	}
	
	
	@PostMapping("esercente")
	public ResponseEntity<String>registrazioneEsercente(@RequestBody EsercenteDto esercenteDto){
		
		logger.info("inizio registrazione esercente");
		
		try {
			String password = passwordEncoder.encode(esercenteDto.getPassword());
			esercenteDto.setPassword(password);
			service.registrazione(esercenteDto);
		}catch (Exception e) {
			return new ResponseEntity<String>("Contattare l'assistenza oppure riprovare.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("fine registrazione esercente");
		return new ResponseEntity<String>("Registrazione Avvenuta con successo",HttpStatus.CREATED);
	}
	
	
	@PutMapping("attivazione-utente")
	public ResponseEntity<String>attivazioneUtente(@RequestParam("idUtente")String idUtente){
		
		logger.info("inizio attivazione utente");
		
		try {
			
			service.attivazioneAutente(idUtente);
			
			
		}catch (Exception e) {
			return new ResponseEntity<String>("Contattare l'assistenza oppure riprovare.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		logger.info("fine attivazione utente");
		return new ResponseEntity<String>("attivazione avvenuta con successo",HttpStatus.OK);
	}
	
	
	
}

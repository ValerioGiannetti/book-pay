package com.bookpay.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.business.Cliente;
import com.bookpay.cloud.business.ClienteService;
import com.bookpay.cloud.business.Prenotazione;

@RestController
@RequestMapping(value = "/api/gestione-cliente/")
public class GestioneClienteController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ClienteService service;
	
	public ResponseEntity<String>registra(@RequestBody Cliente cliente){
		
		logger.info("inizio registra");
		String mess = "";
		try {
			service.registraCliente(cliente);
		}catch (Exception e) {
			logger.info("errore registra");
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		mess = "Registrazione avvenuta con successo";
		logger.info("fine registra");
		return new ResponseEntity<String>(mess,HttpStatus.OK);
	}
	
	public ResponseEntity<List<Prenotazione>>listaPrenotazioni(@RequestParam 
																		String idCliente){
		return null;
	}
	
	
	public ResponseEntity<String>prenotaServizio(@RequestBody Prenotazione prenotazione){
		
		logger.info("inizio prenotaServizio");
		String messaggio = "";
		try {
			service.prenotaServizio(prenotazione);
		}catch (Exception e) {
			logger.error("errore prenotaServizio "+e.getMessage());
			messaggio = "errore";
			return new ResponseEntity<String>(messaggio,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		messaggio="Prenotazione avvenuta con successo";
		logger.info("inizio prenotaServizio");
		return new ResponseEntity<String>(messaggio,HttpStatus.OK);
	}
	
	
}

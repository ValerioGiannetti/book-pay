package com.bookpay.cloud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.business.Esercente;
import com.bookpay.cloud.business.EsercenteService;

@RestController
@RequestMapping(value = "/api/gestione-esercente/")
public class GestioneEsercenteController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EsercenteService service;
	
	@PostMapping(value = "registra")
	public ResponseEntity<String>registrazione(@RequestBody Esercente esercente ){
		
		logger.info("inizio registrazione");
		String mess = "";
		try {
			service.saveEsercente(esercente);	
		}catch (Exception e) {
			logger.info("errore registrazione");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		mess = "Registrazione avvenuta con successo";
		logger.info("fine registrazione");
		return new ResponseEntity<>(mess,HttpStatus.OK);
	}
	@GetMapping(value = "lista-esercenti")
	public ResponseEntity<List<Esercente>> listaEsercenti(){
		
		logger.info("inizio listaEsercenti");
		List<Esercente> lista = null;
		try {
			lista  = service.findAll();	
		}catch (Exception e) {
			logger.info("errore listaEsercenti");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("fine listaEsercenti");
		return new ResponseEntity<List<Esercente>>(lista,HttpStatus.OK);
	}
	
}

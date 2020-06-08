package com.bookpay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.entity.DClienti;
import com.bookpay.service.ClienteService;

@RestController
@RequestMapping(value = "/api/gestione-cliente/")
public class GestioneClienteController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ClienteService service;
	
	public ResponseEntity<String>registra(@RequestBody DClienti cliente){
		
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
	
		
}

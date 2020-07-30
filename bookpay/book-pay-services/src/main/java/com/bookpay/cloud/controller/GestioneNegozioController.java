package com.bookpay.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.dto.NegoziEsercenteDto;
import com.bookpay.cloud.service.NegozioService;

@RestController
@RequestMapping(value = "/api/gestione-negozio/")
public class GestioneNegozioController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private NegozioService negozioService;
	
	@PostMapping(path = "inserisci-negozio")
	public ResponseEntity<String>inserisciNegozio(@RequestBody NegoziEsercenteDto source){
		
		logger.info("dentro inserisciNegozio");
		
		try {
			negozioService.insertNegozio(source);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		logger.info("fine dentro inserisciNegozio");
		return null;
	}
	
	
	
}

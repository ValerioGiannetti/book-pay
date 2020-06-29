package com.bookpay.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.service.ClienteService;
import com.gateway.cloud.dto.ClienteDto;

@RestController
@RequestMapping(value = "/api/gestione-cliente/")
public class GestioneClienteController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("loadProfilo")
	public ResponseEntity<ClienteDto>loadProfilo(@RequestParam("idCliente")String idCliente){
		
		logger.info("inizio loadProfilo");
		
		ClienteDto dto = null;
		try {
			dto = service.loadCliente(idCliente);
		}catch (Exception e) {
			logger.info("errore loadProfilo");
			return new ResponseEntity<ClienteDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("fine loadProfilo");
		return new ResponseEntity<ClienteDto>(dto,HttpStatus.OK);
	}
	
		
}

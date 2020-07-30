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

import com.bookpay.cloud.dto.ClienteDto;
import com.bookpay.cloud.service.ClienteService;

@RestController
@RequestMapping(value = "/api/gestione-cliente/")
public class GestioneClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("cliente/loadProfilo")
	public ResponseEntity<ClienteDto> loadProfilo(@RequestParam(name = "idCliente") String idCliente){
		
		logger.info("inzio loadProfilo cliente");
		ClienteDto clienteDto = new ClienteDto();
		try {
			clienteDto = clienteService.loadProfilo(idCliente);
		}catch (Exception e) {
			return new ResponseEntity<ClienteDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		logger.info("fine loadProfilo cliente");
		return new ResponseEntity<ClienteDto>(clienteDto,HttpStatus.OK);
	}
}

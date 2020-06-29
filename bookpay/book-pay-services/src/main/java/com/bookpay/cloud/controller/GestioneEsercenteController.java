package com.bookpay.cloud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.dto.EsercenteDto;
import com.bookpay.cloud.service.EsercenteService;

@RestController
@RequestMapping(value = "/api/gestione-esercente/")
public class GestioneEsercenteController {

	@Autowired
	private EsercenteService esercenteService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	//@GetMapping(path = "lista-esercenti")
	public ResponseEntity<List<EsercenteDto>> listaEsercentiLatAndLong(@RequestParam("lat")String lat,
															@RequestParam("long")String log ){
		
		logger.info("inizio listaEsercentiLatAndLong");
		
		List<EsercenteDto>listaOutput = esercenteService.getListaLatAndLong(lat,log);
		
		
		ResponseEntity<List<EsercenteDto>> resp = new ResponseEntity<List<EsercenteDto>>(listaOutput,HttpStatus.OK);
		logger.info("fine listaEsercentiLatAndLong");
		return resp;
	}
	
	@GetMapping(path = "lista-esercenti")
	public ResponseEntity<List<EsercenteDto>> listaEsercenti(){
		
		logger.info("inizio listaEsercentiLatAndLong");
		
		List<EsercenteDto>listaOutput = esercenteService.getLista();
		
		
		ResponseEntity<List<EsercenteDto>> resp = new ResponseEntity<List<EsercenteDto>>(listaOutput,HttpStatus.OK);
		logger.info("fine listaEsercentiLatAndLong");
		return resp;
	}
	
}

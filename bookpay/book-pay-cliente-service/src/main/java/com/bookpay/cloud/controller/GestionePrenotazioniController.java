package com.bookpay.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.business.ClienteService;
import com.bookpay.cloud.business.ContainerCliente;
import com.bookpay.cloud.business.Prenotazione;

@RestController
@RequestMapping(value = "/api/gestione/prenotazioni/")
public class GestionePrenotazioniController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ClienteService service;

	@GetMapping(value = "lista-prenotazioni/{id}")
	public ResponseEntity<ContainerCliente> listaPrenotazioni(@PathVariable("id") String idCliente) {

		logger.info("inizio listaPrenotazioni");
		ContainerCliente output = null;
		try {
			output = service.listaPrenotazioniWeek(idCliente);
		} catch (Exception e) {
			logger.error("errore listaPrenotazioni " + e.getMessage());
			return new ResponseEntity<ContainerCliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("fine listaPrenotazioni");
		return new ResponseEntity<ContainerCliente>(output, HttpStatus.OK);
	}
	
	public ResponseEntity<String> prenotaServizio(@RequestParam(value = "idCliente")String idCliente,
											@RequestParam(value = "idEsercente")String idEsercente) {

		logger.info("inizio prenotaServizio");
		String messaggio = "";
		try {
			service.prenotaServizio(idCliente,idEsercente);
		} catch (Exception e) {
			logger.error("errore prenotaServizio " + e.getMessage());
			messaggio = "errore";
			return new ResponseEntity<String>(messaggio, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		messaggio = "Prenotazione avvenuta con successo";
		logger.info("inizio prenotaServizio");
		return new ResponseEntity<String>(messaggio, HttpStatus.OK);
	}

}

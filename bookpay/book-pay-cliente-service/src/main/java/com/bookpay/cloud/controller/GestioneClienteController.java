package com.bookpay.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> sviluppo-microservices
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.bookpay.cloud.business.Cliente;
import com.bookpay.cloud.business.ClienteService;
=======
import com.bookpay.cloud.service.ClienteService;
import com.gateway.cloud.dto.ClienteDto;
>>>>>>> sviluppo-microservices

@RestController
@RequestMapping(value = "/api/gestione-cliente/")
public class GestioneClienteController {

	private Logger logger = LoggerFactory.getLogger(getClass());
<<<<<<< HEAD

	@Autowired
	private ClienteService service;

	@GetMapping(value = "/prova")
	public ResponseEntity<String> provaMicro() {
		logger.info("inizio provaMicro");

		logger.info("inizio provaMicro");

		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

	public ResponseEntity<String> registra(@RequestBody Cliente cliente) {

		logger.info("inizio registra");
		String mess = "";
		try {
			service.registraCliente(cliente);
		} catch (Exception e) {
			logger.info("errore registra");
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		mess = "Registrazione avvenuta con successo";
		logger.info("fine registra");
		return new ResponseEntity<String>(mess, HttpStatus.OK);
	}

	@PostMapping(value = "info-cliente")
	public ResponseEntity<?> getInfoCliente(@RequestParam(value = "jsonUt") String jsonUt) {
		logger.info("inizio getInfoCliente");
		JSONObject jsonObject = null;
		String idCliente = "";
		String token = "";
		try {
			jsonObject = new JSONObject(jsonUt.toString());
			idCliente = jsonObject.getString("idCliente");
			token = jsonObject.getString("token");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cliente cliente = service.getCliente(idCliente);
		cliente.setToken(token);

		logger.info("fine getInfoCliente");

		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

=======
	
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
	
		
>>>>>>> sviluppo-microservices
}

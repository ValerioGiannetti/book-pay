package com.bookpay.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.dto.StaffDto;
import com.bookpay.cloud.service.StaffService;

@RestController
@RequestMapping(value = "/api/gestione-staff/")
public class GestioneStaffNegozioController {


	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private StaffService service;
	
	@PostMapping(path = "saveStaff")
	public ResponseEntity<String>insertStaff(@RequestBody StaffDto staffDto){
		
		logger.info("inizio insertStaff");
		
		try {
			service.saveStaff(staffDto);
		}catch (Exception e) {
			logger.info("errore "+e.getMessage());
			//TODO gestire eccezione
		}
		
		
		logger.info("fine insertStaff");
		return new ResponseEntity<String>("Inserimento Avvenuto con Successo",HttpStatus.OK);
	}
	
	@DeleteMapping(path = "deleteStaff")
	public ResponseEntity<String>deleteStaff(@RequestParam("idStaff") String idStaff){
		
		logger.info("inizio deleteStaff");
		
		try {
			service.deleteStaff(idStaff);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		logger.info("fine deleteStaff");
		
		return new ResponseEntity<String>("Cancellazione avvenuta con successo",HttpStatus.OK);
	}
	
	@PutMapping(path = "updateStaff")
	public ResponseEntity<String>updateStaff(@RequestBody StaffDto dto){
		
		logger.info("inizio updateStaff");
		
		try {
			service.updateStaff(dto);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		logger.info("fine updateStaff");
		return new ResponseEntity<String>("Aggiornamento avvenuto con successo",HttpStatus.OK);
	}
	
	
	
	
}

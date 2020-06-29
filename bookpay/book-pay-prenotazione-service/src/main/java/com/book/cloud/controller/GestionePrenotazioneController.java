package com.book.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.cloud.dto.DatiPrenotazioneDto;
import com.book.cloud.entity.DClienti;
import com.book.cloud.entity.DPrenotazioni;
import com.book.cloud.entity.DStaffNegozio;
import com.book.cloud.service.PrenotazioneService;

@RestController
@RequestMapping(value = "/api/gestione-prenotazione/")
public class GestionePrenotazioneController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PrenotazioneService service;
	
	
	@PostMapping(value = "prenotazione")
	public ResponseEntity<Boolean>prenota(@RequestBody DatiPrenotazioneDto dto){
		
		logger.info("inizio prenota");
		
		DPrenotazioni dPrenotazioni = new DPrenotazioni();
		DClienti dClienti = service.loadCliente(dto.getIdCliente());
		
		DStaffNegozio dStaffNegozio = service.loadStaffNegozio(dto.getIdStaffNegozio());
		dPrenotazioni.setDClienti(dClienti);
		dPrenotazioni.setDStaffNegozio(dStaffNegozio);
		
		
		dPrenotazioni.setOra(String.valueOf(dto.getOra()));
		dPrenotazioni.setMinuti(String.valueOf(dto.getMinuti()));
		dPrenotazioni.setAnno(dto.getAnno());
		dPrenotazioni.setGiorno(dto.getGiorno());
		dPrenotazioni.setMese(dto.getMese());
		
		
		try {
			service.prenota(dPrenotazioni);
		}catch (Exception e) {
			logger.info("Errore "+e.getMessage());
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		/*TODO
		 * implentare sistema di notificazione per l'esercente
		 * perchè per il cliente ci pensa il sistema android 
		 */
		logger.info("fine prenota");
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@PutMapping(value = "prenotazione-consumata")
	public ResponseEntity<String> prenotazioneConsumata(@RequestParam String idClienteApp){
		
		logger.info("inizio prenotazioneConsumanta");
		
		
		logger.info("fine prenotazioneConsumanta");
		return null;
	}
	
	
	
	
}

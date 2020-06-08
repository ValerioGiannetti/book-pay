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
		
//		ClientiAppuntamentiEntity entity = new ClientiAppuntamentiEntity();
//		ClientiEntity clientiEntity = service.loadCliente(dto.getIdCliente());
//		EsercenteEntity esercenteEntity = service.loadEsercente(dto.getIdEsercente());
//		
//		entity.setClientiEntity(clientiEntity);
//		entity.setEsercenteEntity(esercenteEntity);
//		entity.setEsercenteNegozioEntity(esercenteEntity.getNegozio(dto.getIdEsercenteNegozio()));
//		
//		entity.setNote(dto.getNote());
//		entity.setData(dto.getDataAppuntamento());
//		entity.setOra(String.valueOf(dto.getOra()));
//		entity.setMinuti(String.valueOf(dto.getMinuti()));
//		
//		try {
//			service.prenota(entity);
//		}catch (Exception e) {
//			logger.info("Errore "+e.getMessage());
//			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		/*TODO
		 * implentare sistema di notificazione per l'esercente
		 * perchè per il cliente ci pensa il sistema android 
		 */
		logger.info("fine prenota");
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@PutMapping(value = "prenotazione-consumata")
	public ResponseEntity<String> prenotazioneConsumanta(@RequestParam String idClienteApp){
		
		logger.info("inizio prenotazioneConsumanta");
		
		
		logger.info("fine prenotazioneConsumanta");
		return null;
	}
	
	
	
	
}

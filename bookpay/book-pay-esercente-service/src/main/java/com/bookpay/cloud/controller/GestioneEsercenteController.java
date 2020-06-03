package com.bookpay.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpay.cloud.business.EsercenteService;
import com.bookpay.cloud.dto.EsercenteDto;
import com.bookpay.cloud.dto.NegozioEsercenteDto;
import com.bookpay.cloud.entity.EsercenteEntity;
import com.bookpay.cloud.entity.EsercenteNegozioEntity;

@RestController
@RequestMapping(value = "/api/gestione-esercente/")
public class GestioneEsercenteController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EsercenteService service;

	@PostMapping(value = "registra")
	public ResponseEntity<String> registrazione(@RequestBody EsercenteEntity esercente) {

		logger.info("inizio registrazione");
		String mess = "";
		try {
			service.saveEsercente(esercente);
		} catch (Exception e) {
			logger.info("errore registrazione");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		mess = "Registrazione avvenuta con successo";
		logger.info("fine registrazione");
		return new ResponseEntity<>(mess, HttpStatus.OK);
	}

	@GetMapping(value = "lista-esercenti")
	public ResponseEntity<List<EsercenteDto>> listaEsercenti() {

		logger.info("inizio listaEsercenti");
		List<EsercenteEntity> lista = null;
		List<EsercenteDto> listaOutput = null;
		List<NegozioEsercenteDto> listaNegozioOutput = null;
		try {

			lista = service.findAll();

			if (lista != null && !lista.isEmpty()) {

				listaOutput = new ArrayList<EsercenteDto>();
				listaNegozioOutput = new ArrayList<NegozioEsercenteDto>();
				for (EsercenteEntity esercenteEntity : lista) {
					EsercenteDto dto = new EsercenteDto();

					BeanUtils.copyProperties(esercenteEntity, dto);
					for (EsercenteNegozioEntity esercenteNegozioEntity : esercenteEntity.getListaNegozi()) {
						NegozioEsercenteDto neDto = new NegozioEsercenteDto();
						BeanUtils.copyProperties(esercenteNegozioEntity, neDto);
						listaNegozioOutput.add(neDto);
					}
					dto.setListaNegozi(listaNegozioOutput);
					listaOutput.add(dto);
				}

			}

		} catch (Exception e) {
			logger.info("errore listaEsercenti");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("fine listaEsercenti");
		return new ResponseEntity<List<EsercenteDto>>(listaOutput, HttpStatus.OK);
	}

}

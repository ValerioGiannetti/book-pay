package com.bookpay.cloud.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
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
import com.bookpay.cloud.dto.NegoziEsercenteDto;
import com.bookpay.cloud.dto.StaffDto;
import com.bookpay.cloud.entity.DEsercente;
import com.bookpay.cloud.util.SwapObject;


@RestController
@RequestMapping(value = "/api/gestione-esercente/")
public class GestioneEsercenteController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	private List<EsercenteDto> listaOutput;
	
	@Autowired
	private EsercenteService service;
	
	
	@PostMapping(value = "registra")
	public ResponseEntity<String> registrazione(@RequestBody EsercenteDto dto) {

		logger.info("inizio registrazione");
		String mess = "";
		
		try {
		
			service.saveEsercente(dto);
			
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
		List<DEsercente> lista = null;
		
		try {

			lista = service.findAll();

			if (lista != null && !lista.isEmpty()) {

				listaOutput = new ArrayList<EsercenteDto>();
				SwapObject<DEsercente, EsercenteDto> swap = new SwapObject<DEsercente, EsercenteDto>();
				lista.forEach(esercente->{
					EsercenteDto dto = new EsercenteDto();
					try {
						swap.copyProperties(esercente, dto);
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
							| SecurityException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					listaOutput.add(dto);
				});

			}

		} catch (Exception e) {
			logger.info("errore listaEsercenti");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("fine listaEsercenti");
		return new ResponseEntity<List<EsercenteDto>>(listaOutput, HttpStatus.OK);
	}

	private void setDtoFromEntity(DEsercente esercenteEntity, EsercenteDto dto) {
		
		
		
		
		
		
		dto.setIdEsercente(String.valueOf(esercenteEntity.getIdEsercente()));
		dto.setIdUtente(String.valueOf(esercenteEntity.getDUtente().getIdUtente()));
		dto.setPiva(esercenteEntity.getPiva());
		dto.setNome(esercenteEntity.getDUtente().getNome());
		dto.setEmail(esercenteEntity.getDUtente().getEmail());
		dto.setPassword(esercenteEntity.getDUtente().getPassword());
		dto.setListaNegozi(new LinkedHashSet<NegoziEsercenteDto>());
		
		esercenteEntity.getDNegoziEsercentes().forEach(consumer->{
			
			NegoziEsercenteDto neDto = new NegoziEsercenteDto();
			BeanUtils.copyProperties(consumer, neDto);
			
			neDto.setCap(consumer.getCap());
			neDto.setIdNegoziEsercente(String.valueOf(consumer.getIdNegoziEsercente()));
			neDto.setVia(consumer.getVia());
			neDto.setLatitudine(consumer.getLatitudine());
			neDto.setLongitudine(consumer.getLongitudine());
			neDto.setNome(consumer.getNome());
			
			neDto.setListaStaff(new LinkedHashSet<StaffDto>());
			
			consumer.getDStaffNegozios().forEach(staff->{
				
				StaffDto dtoStaff = new StaffDto();
				
				dtoStaff.setCognome(staff.getCognome());
				dtoStaff.setNome(staff.getNome());
				dtoStaff.setNumeroAppuntamentiGiorno(staff.getNumeroAppuntamentiGiorno());
				
				neDto.getListaStaff().add(dtoStaff);
				
			});
				
			dto.getListaNegozi().add(neDto);	
			
		});
		
	}

}

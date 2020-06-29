package com.bookpay.cloud.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpay.cloud.dto.ClienteDto;
import com.bookpay.cloud.dto.EsercenteDto;
import com.bookpay.cloud.dto.NegoziEsercenteDto;
import com.bookpay.cloud.dto.StaffDto;
import com.bookpay.cloud.dto.UtenteDto;
import com.bookpay.cloud.entity.DClienti;
import com.bookpay.cloud.entity.DEsercente;
import com.bookpay.cloud.entity.DNegoziEsercente;
import com.bookpay.cloud.entity.DStaffNegozio;
import com.bookpay.cloud.entity.DUtente;
import com.bookpay.cloud.repository.UtenteRepository;
import com.bookpay.cloud.utility.SwapObject;

@Service
@Transactional
public class UtenteServiceImpl implements UtenteService {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UtenteRepository repository;
	
	@Override
	public void registrazione(UtenteDto utenteDto) {
		
		logger.info("inizio registrazione utente");
		
		DUtente utente = new DUtente();
		
		if(utenteDto instanceof ClienteDto) {
			
			ClienteDto clienteDto = (ClienteDto) utenteDto;
			
			DClienti dClienti = new DClienti();
			
			dClienti.setCognome(clienteDto.getCognome());
			dClienti.setNome(clienteDto.getNome());
			dClienti.setCap(clienteDto.getCap());
			dClienti.setLatitudine(clienteDto.getLatitudine());
			dClienti.setLongitudine(clienteDto.getLongitudine());
			
			utente.setCittaIstat(Integer.valueOf(clienteDto.getCodiceIstat()));
			utente.setDataRegistrazione(Calendar.getInstance().getTime());
			utente.setEmail(clienteDto.getEmail());
			utente.setNome(clienteDto.getNome());
			utente.setAttivo("N");
			utente.setEsercente(null);
			utente.setCliente(dClienti);
			utente.setPassword(clienteDto.getPassword());
			
			
			
		}else if(utenteDto instanceof EsercenteDto) {
			
			EsercenteDto esercenteDto = (EsercenteDto) utenteDto;
			
			DEsercente dEsercente = new DEsercente();
			dEsercente.setPiva(esercenteDto.getPiva());
			dEsercente.setListaNegozi(new HashSet<>());
			
			SwapObject<NegoziEsercenteDto, DNegoziEsercente>sw = new SwapObject<>();
			SwapObject<StaffDto, DStaffNegozio>staffSw = new SwapObject<>();
			for (NegoziEsercenteDto source : esercenteDto.getListaNegozi()) {
				DNegoziEsercente target = new DNegoziEsercente();
				try {
					sw.copyProperties(source, target);
					target.setDEsercente(dEsercente);
					target.setDStaffNegozios(new HashSet<>());
					
					
					for (StaffDto dtoTarget : source.getListaStaff()) {
						
						DStaffNegozio staffSource = new DStaffNegozio();
						
						staffSw.copyProperties(dtoTarget, staffSource);
						target.getDStaffNegozios().add(staffSource);
						staffSource.setDNegoziEsercente(target);
					}
					
					
				} catch (IllegalArgumentException | IllegalAccessException 
						| NoSuchFieldException | SecurityException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dEsercente.getListaNegozi().add(target);
			}
			
			
			utente.setCittaIstat(Integer.valueOf(esercenteDto.getCodiceIstat()));
			utente.setDataRegistrazione(Calendar.getInstance().getTime());
			utente.setEmail(esercenteDto.getEmail());
			utente.setNome(esercenteDto.getNome());
			utente.setAttivo("N");
			utente.setEsercente(dEsercente);
			utente.setCliente(null);
			utente.setPassword(esercenteDto.getPassword());
			dEsercente.setDUtente(utente);
		}
		try {
			repository.save(utente);
		}catch (Exception e) {
			throw e;
		}
		
		
		logger.info("fine registrazione utente");
	}

}

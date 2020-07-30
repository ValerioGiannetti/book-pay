package com.bookpay.cloud.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bookpay.cloud.dto.NegoziEsercenteDto;
import com.bookpay.cloud.entity.DNegoziEsercente;
import com.bookpay.cloud.repository.NegozioRepository;
import com.bookpay.cloud.utility.SwapObject;

@Service
@Transactional
public class NegozioServiceImpl implements NegozioService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private NegozioRepository repository;
	
	@Override
	public void insertNegozio(NegoziEsercenteDto source) {
		
		logger.info("inizio insertNegozio");
		SwapObject<NegoziEsercenteDto, DNegoziEsercente> swp = new SwapObject<>();
		
		try {
			DNegoziEsercente dNegoziEsercente = new DNegoziEsercente();
			swp.copyProperties(source, dNegoziEsercente);
			repository.save(dNegoziEsercente);
		}catch (Exception e) {
			logger.info("errore "+e.getMessage());
		}
		
		
		logger.info("fine insertNegozio");
		
	}

}

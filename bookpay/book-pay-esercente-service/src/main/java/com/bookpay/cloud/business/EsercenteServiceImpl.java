package com.bookpay.cloud.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EsercenteServiceImpl implements EsercenteService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EsercenteRepository repository;

	@Override
	public Esercente findEsercente(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEsercente(Esercente esercente) {
		logger.info("inizio saveEsercente");
		try {
			repository.insert(esercente);
		}catch (Exception e) {
			logger.info("errore saveEsercente");
			throw e;
		}
		logger.info("fine saveEsercente");
	}

	@Override
	public List<Esercente> findAll() {
		logger.info("inizio findAll");
		List<Esercente>listaEser = null;
		try {
			listaEser = repository.findAll();
		}catch (Exception e) {
			logger.info("errore findAll");
			throw e;
		}
		logger.info("fine findAll");
		return listaEser;
	}

	@Override
	public List<Esercente> findByLatAndLong(String lat, String longi) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

package com.bookpay.cloud.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookpay.cloud.entity.EsercenteEntity;
import com.bookpay.cloud.repository.EsercenteRepository;

@Service
@Transactional
public class EsercenteServiceImpl implements EsercenteService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EsercenteRepository repository;

	@Override
	public EsercenteEntity findEsercente(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEsercente(EsercenteEntity esercente) {
		logger.info("inizio saveEsercente");
		try {
			repository.save(esercente);
		}catch (Exception e) {
			logger.info("errore saveEsercente");
			throw e;
		}
		logger.info("fine saveEsercente");
	}

	@Override
	public List<EsercenteEntity> findAll() {
		logger.info("inizio findAll");
		List<EsercenteEntity>listaEser = null;
		try {
			listaEser = (List<EsercenteEntity>) repository.findAll();
		}catch (Exception e) {
			logger.info("errore findAll");
			throw e;
		}
		logger.info("fine findAll");
		return listaEser;
	}

	@Override
	public List<EsercenteEntity> findByLatAndLong(String lat, String longi) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

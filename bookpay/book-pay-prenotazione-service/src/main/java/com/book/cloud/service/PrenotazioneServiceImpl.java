package com.book.cloud.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.cloud.entity.ClientiAppuntamentiEntity;
import com.book.cloud.repository.PrenotazioneRepository;

@Service
@Transactional
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PrenotazioneRepository repository;
	
	@Override
	public void prenota(ClientiAppuntamentiEntity appuntamentiEntity) {
		
		logger.info("inizio prenota");
		
		try {
			repository.save(appuntamentiEntity);
		}catch (Exception e) {
			throw e;
		}
		
		logger.info("fine prenota");
		
	}

}

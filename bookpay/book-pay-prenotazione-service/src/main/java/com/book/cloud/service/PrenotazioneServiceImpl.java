package com.book.cloud.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.cloud.entity.ClientiAppuntamentiEntity;
import com.book.cloud.entity.ClientiEntity;
import com.book.cloud.entity.EsercenteEntity;
import com.book.cloud.repository.ClienteRepository;
import com.book.cloud.repository.EsercenteRepository;
import com.book.cloud.repository.PrenotazioneRepository;

@Service
@Transactional
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private ClientiEntity clientiEntity;
	private EsercenteEntity esercenteEntity;
	
	@Autowired
	private PrenotazioneRepository repository;
	
	@Autowired
	private EsercenteRepository esercenteRepository;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
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

	@Override
	public ClientiEntity loadCliente(String idCliente) {
		
		logger.info("inizio loadCliente");
		
		Optional<ClientiEntity> output = clienteRepo.findById(Long.valueOf(idCliente));
		
		output.ifPresent(consumer->{
			clientiEntity = consumer;
			
		});
		
		logger.info("fine loadCliente");
		
		return clientiEntity;
	}

	@Override
	public EsercenteEntity loadEsercente(String idEsercente) {

		logger.info("inizio loadEsercente");

		Optional<EsercenteEntity> output = esercenteRepository.findById(Long.valueOf(idEsercente));

		output.ifPresent(consumer -> {
			esercenteEntity = consumer;

		});

		logger.info("fine loadEsercente");

		return esercenteEntity;

	}

}

package com.bookpay.cloud.business;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PrenotazioneRepository prenotazioneRepo;
	
	
	
	
	
	@Override
	public void registraCliente(Cliente cliente) {
		logger.info("inizio registraCliente");
		try {
			repository.insert(cliente);
		}catch (Exception e) {
			logger.info("errore registraCliente");
			throw e;
		}
		logger.info("fine registraCliente");
	}

	@Override
	public void prenotaServizio(Prenotazione prenotazione) {
		logger.info("inizio prenotaServizio");
		try {
			prenotazioneRepo.insert(prenotazione);
		}catch (Exception e) {
			logger.error("errore prenotaServizio "+e.getMessage());
			throw e;
		}
		logger.info("fine prenotaServizio");
	}

	@Override
	public ContainerCliente listaPrenotazioniWeek(String idCliente) {
		
		logger.info("inizio listaPrenotazioniWeek");
		final ContainerCliente output = new ContainerCliente();
		try {
			
			
			
			
			Optional<Cliente>op = repository.findById(idCliente);
			op.ifPresent(value->{
				output.setCliente(value);
				output.setPrenotazione(prenotazioneRepo.findByIdCliente(value.getId()));
			});
		}catch (Exception e) {
			logger.error("errore listaPrenotazioniWeek "+e.getMessage());
		}
		
		logger.info("fine listaPrenotazioniWeek");
		return output;
	}

	@Override
	public Cliente getCliente(String idCliente) {
		
		logger.info("inizio getCliente");
		
		Optional<Cliente>output = repository.findById(idCliente);
		logger.info("fine getCliente");
		return output.get();
	}
		
	
}

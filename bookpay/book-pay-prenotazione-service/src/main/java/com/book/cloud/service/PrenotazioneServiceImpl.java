package com.book.cloud.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.cloud.entity.DClienti;
import com.book.cloud.entity.DEsercente;
import com.book.cloud.entity.DPrenotazioni;
import com.book.cloud.entity.DStaffNegozio;
import com.book.cloud.repository.ClienteRepository;
import com.book.cloud.repository.EsercenteRepository;
import com.book.cloud.repository.PrenotazioneRepository;
import com.book.cloud.repository.StaffNegozioRepository;

@Service
@Transactional
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private DClienti clientiEntity;
	private DEsercente esercenteEntity;
	private DStaffNegozio staffNegozioEntity;
	
	@Autowired
	private PrenotazioneRepository repository;
	
	@Autowired
	private EsercenteRepository esercenteRepository;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private StaffNegozioRepository staffRepository;
	
	@Override
	public void prenota(DPrenotazioni entity) {
		
		logger.info("inizio prenota");
		String dataAppuntamento = entity.getAnno()+"-"+entity.getMese()+"-"+entity.getGiorno();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.ITALY);
		try {
			Date dataPrenotazione = format.parse(dataAppuntamento);
			entity.setDataPrenotazione(dataPrenotazione);
			repository.save(entity);
		}catch (ParseException e1) {
			e1.printStackTrace();
		}
		catch (Exception e) {
			throw e;
		}
		
		logger.info("fine prenota");
		
	}

	@Override
	public DClienti loadCliente(String idCliente) {
		
		logger.info("inizio loadCliente");
		
		Optional<DClienti> output = clienteRepo.findById(Integer.valueOf(idCliente));
		
		output.ifPresent(consumer->{
			clientiEntity = consumer;
			
		});
		
		logger.info("fine loadCliente");
		
		return clientiEntity;
	}

	@Override
	public DEsercente loadEsercente(String idEsercente) {

		logger.info("inizio loadEsercente");

		Optional<DEsercente
		> output = esercenteRepository.findById(Long.valueOf(idEsercente));

		output.ifPresent(consumer -> {
			esercenteEntity = consumer;

		});

		logger.info("fine loadEsercente");

		return esercenteEntity;

	}

	@Override
	public DStaffNegozio loadStaffNegozio(String idStaffNegozio) {
		
		
		logger.info("inizio loadStaffNegozio");

		Optional<DStaffNegozio> output = staffRepository.findById(Integer.valueOf(idStaffNegozio));

		output.ifPresent(consumer -> {
			staffNegozioEntity = consumer;

		});

		logger.info("fine loadStaffNegozio");

		return staffNegozioEntity;
		
		
	}

}

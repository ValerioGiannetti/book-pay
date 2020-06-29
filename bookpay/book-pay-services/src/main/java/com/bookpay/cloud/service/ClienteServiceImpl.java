package com.bookpay.cloud.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpay.cloud.dto.ClienteDto;
import com.bookpay.cloud.entity.DClienti;
import com.bookpay.cloud.repository.ClienteRepository;
import com.bookpay.cloud.utility.SwapObject;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void registraCliente(ClienteDto clienteDto) {
		
		logger.info("inizio registrazione cliente ");
		
		try {
			
			
			
			
		}catch (Exception e) {
			throw e;
		}
		
		
		logger.info("fine registrazione cliente ");
		
	}

	@Override
	public ClienteDto loadProfilo(String idCliente) {
		
		logger.info("inizio loadProfilo");
		SwapObject<DClienti, ClienteDto> swp = new SwapObject<>();
		ClienteDto target = new ClienteDto();
		
		
		try {
			Optional<DClienti>profilo = repository.findById(Integer.valueOf(idCliente));
			profilo.ifPresent(source->{
				try {
					swp.copyProperties(source, target);
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.error(e.getMessage());
				}
			});
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		logger.info("fine loadProfilo");
		return target;
	}

}

package com.bookpay.cloud.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;

import com.bookpay.cloud.entity.DClienti;
import com.bookpay.cloud.repository.ClienteRepository;
import com.gateway.cloud.dto.ClienteDto;

public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void registraCliente(DClienti cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteDto loadCliente(String idCliente) {
		
		logger.info("inizio loadCliente "+idCliente);
		
		Optional<DClienti> dClienti = repository.findById(Integer.valueOf(idCliente)); 
		
		ClienteDto clienteDto = new ClienteDto();
		
		dClienti.ifPresent(value->{
			BeanUtils.copyProperties(value, clienteDto);
		});
		
		logger.info("fine loadCliente "+idCliente);
		return clienteDto;
	}

}

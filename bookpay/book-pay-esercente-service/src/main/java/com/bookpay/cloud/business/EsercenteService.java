package com.bookpay.cloud.business;

import java.util.List;

import com.bookpay.cloud.dto.EsercenteDto;
import com.bookpay.cloud.entity.DEsercente;


public interface EsercenteService {

	
	public DEsercente findEsercente(String nome);
	
	public void saveEsercente(EsercenteDto dto);
	
	public List<DEsercente> findAll();
	
	public List<DEsercente> findByLatAndLong(String lat,String longi);

	
	
}

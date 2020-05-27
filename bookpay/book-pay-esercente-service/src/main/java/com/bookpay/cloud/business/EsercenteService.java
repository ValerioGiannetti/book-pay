package com.bookpay.cloud.business;

import java.util.List;

import com.bookpay.cloud.entity.EsercenteEntity;

public interface EsercenteService {

	
	public EsercenteEntity findEsercente(String nome);
	
	public void saveEsercente(EsercenteEntity esercente);
	
	public List<EsercenteEntity>findAll();
	
	public List<EsercenteEntity>findByLatAndLong(String lat,String longi);

	
	
}

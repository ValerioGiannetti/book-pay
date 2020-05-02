package com.bookpay.cloud.business;

import java.util.List;

public interface EsercenteService {

	
	public Esercente findEsercente(String nome);
	
	public void saveEsercente(Esercente esercente);
	
	public List<Esercente>findAll();
	
	public List<Esercente>findByLatAndLong(String lat,String longi);

	
	
}

package com.book.cloud.service;

import com.book.cloud.entity.ClientiAppuntamentiEntity;
import com.book.cloud.entity.ClientiEntity;
import com.book.cloud.entity.EsercenteEntity;

public interface PrenotazioneService {

	
	public void prenota(ClientiAppuntamentiEntity appuntamentiEntity);

	public ClientiEntity loadCliente(String idCliente);

	public EsercenteEntity loadEsercente(String idEsercente);
	
}

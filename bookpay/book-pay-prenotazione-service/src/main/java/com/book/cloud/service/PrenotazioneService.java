package com.book.cloud.service;

import com.book.cloud.entity.DClienti;
import com.book.cloud.entity.DEsercente;
import com.book.cloud.entity.DPrenotazioni;

public interface PrenotazioneService {

	
	public void prenota(DPrenotazioni appuntamentiEntity);

	public DClienti loadCliente(String idCliente);

	public DEsercente loadEsercente(String idEsercente);
	
}

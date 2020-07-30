package com.bookpay.cloud.service;

import com.bookpay.cloud.dto.UtenteDto;

public interface UtenteService {

	public void registrazione(UtenteDto utenteDto);

	public void attivazioneAutente(String idUtente);
}

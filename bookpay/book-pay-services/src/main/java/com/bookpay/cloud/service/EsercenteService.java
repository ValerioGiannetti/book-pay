package com.bookpay.cloud.service;

import java.util.List;

import com.bookpay.cloud.dto.EsercenteDto;

public interface EsercenteService {

	public List<EsercenteDto> getListaLatAndLong(String lat, String log);

	public void registraEsercente(EsercenteDto esercenteDto);

	public List<EsercenteDto> getLista();

}

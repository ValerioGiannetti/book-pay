package com.bookpay.cloud.service;

import com.bookpay.cloud.dto.ClienteDto;

public interface ClienteService {

	public void registraCliente(ClienteDto clienteDto);

	public ClienteDto loadProfilo(String idCliente);

}

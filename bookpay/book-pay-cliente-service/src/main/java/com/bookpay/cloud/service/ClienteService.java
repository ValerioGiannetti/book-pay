package com.bookpay.cloud.service;

import com.bookpay.cloud.entity.DClienti;
import com.gateway.cloud.dto.ClienteDto;

public interface ClienteService {

	public void registraCliente(DClienti cliente);

	public ClienteDto loadCliente(String idCliente);

}

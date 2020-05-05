package com.bookpay.cloud.business;

public interface ClienteService {

	public void registraCliente(Cliente cliente);

	public void prenotaServizio(String idCliente,String idEsercente);

	public ContainerCliente listaPrenotazioniWeek(String idCliente);

	public Cliente getCliente(String idCliente);
	
	
}

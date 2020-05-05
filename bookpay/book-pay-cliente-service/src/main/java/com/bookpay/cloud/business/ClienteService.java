package com.bookpay.cloud.business;

public interface ClienteService {

	public void registraCliente(Cliente cliente);

	public void prenotaServizio(Prenotazione prenotazione);

	public ContainerCliente listaPrenotazioniWeek(String idCliente);

	public Cliente getCliente(String idCliente);
	
	
}

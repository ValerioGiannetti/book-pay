package com.bookpay.cloud.business;

import java.util.List;

public class ContainerCliente {

	private Cliente cliente;
	private List<Prenotazione> prenotazione;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Prenotazione> getPrenotazione() {
		return prenotazione;
	}
	public void setPrenotazione(List<Prenotazione> prenotazione) {
		this.prenotazione = prenotazione;
	}
	
	
	
}

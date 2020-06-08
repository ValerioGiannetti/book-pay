package com.gateway.cloud.dto;

import java.util.HashSet;
import java.util.Set;

public class ClienteDto extends UtenteDto{

	private String idClienti;
	private String nome;
	private String cognome;
	private String via;
	private String cap;
	private String latitudine;
	private String longitudine;
	private Set<PrenotazioniDto> listaPrenotazioni = new HashSet<PrenotazioniDto>(0);
	
	public String getIdClienti() {
		return idClienti;
	}
	public void setIdClienti(String idClienti) {
		this.idClienti = idClienti;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}
	public String getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}
	public Set<PrenotazioniDto> getListaPrenotazioni() {
		return listaPrenotazioni;
	}
	public void setListaPrenotazioni(Set<PrenotazioniDto> listaPrenotazioni) {
		this.listaPrenotazioni = listaPrenotazioni;
	}
	
	
}

package com.gateway.cloud.dto;

import java.util.HashSet;
import java.util.Set;

public class StaffDto {

	private String idStaffNegozio;
	
	private String nome;
	private String cognome;
	private String numeroAppuntamentiGiorno;
	
	private Set<PrenotazioniDto> listaPrenotazioni = new HashSet<PrenotazioniDto>(0);

	public String getIdStaffNegozio() {
		return idStaffNegozio;
	}

	public void setIdStaffNegozio(String idStaffNegozio) {
		this.idStaffNegozio = idStaffNegozio;
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

	public String getNumeroAppuntamentiGiorno() {
		return numeroAppuntamentiGiorno;
	}

	public void setNumeroAppuntamentiGiorno(String numeroAppuntamentiGiorno) {
		this.numeroAppuntamentiGiorno = numeroAppuntamentiGiorno;
	}

	public Set<PrenotazioniDto> getListaPrenotazioni() {
		return listaPrenotazioni;
	}

	public void setListaPrenotazioni(Set<PrenotazioniDto> listaPrenotazioni) {
		this.listaPrenotazioni = listaPrenotazioni;
	}
	
	

}

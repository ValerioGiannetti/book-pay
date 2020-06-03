package com.bookpay.cloud.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class NegozioEsercenteDto {

	
	private String idEsercenteNegozio;
    
	private String nomeNegozio;
    private String email;
    private String telefono;
    private String indirizzo;
    private String civico;
    private String cap;
    private String citta;
    private String latitudine;
    private String longitudine;
    
	public String getIdEsercenteNegozio() {
		return idEsercenteNegozio;
	}
	public void setIdEsercenteNegozio(String idEsercenteNegozio) {
		this.idEsercenteNegozio = idEsercenteNegozio;
	}
	public String getNomeNegozio() {
		return nomeNegozio;
	}
	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
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
    
    
    
    
}

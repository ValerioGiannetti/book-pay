package com.bookpay.cloud.dto;

import java.util.List;

import com.bookpay.cloud.entity.EsercenteNegozioEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@JsonDeserialize
public class EsercenteDto {

	
	private Long idEsercente;
	private String nome;
	private String cognome;
    private String dataNascita;
    private String email;
    private String telefono;
    private String indirizzo;
    private String civico;
    private String cap;
    private String citta;
    private List<NegozioEsercenteDto>listaNegozi;
	
    public Long getIdEsercente() {
		return idEsercente;
	}
	public void setIdEsercente(Long idEsercente) {
		this.idEsercente = idEsercente;
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
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
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
	public List<NegozioEsercenteDto> getListaNegozi() {
		return listaNegozi;
	}
	public void setListaNegozi(List<NegozioEsercenteDto> listaNegozi) {
		this.listaNegozi = listaNegozi;
	}
    
    
    
    
    
}

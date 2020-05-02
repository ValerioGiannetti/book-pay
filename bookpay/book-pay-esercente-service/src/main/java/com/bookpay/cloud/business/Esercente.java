package com.bookpay.cloud.business;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Esercente {
	
	@Id
	private String id;
	private String nomeEsercente;
	private String nomeAttivita;
	private String via;
	private String citta;
	private int numeroCivico;
	private String tipologiaAttivita;
	private int oraApertura;
	private int oraChiusura;
	private String[]servizi;
	
	
	private String password;
	@Indexed(unique = true)
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeEsercente() {
		return nomeEsercente;
	}
	public void setNomeEsercente(String nomeEsercente) {
		this.nomeEsercente = nomeEsercente;
	}
	public String getNomeAttivita() {
		return nomeAttivita;
	}
	public void setNomeAttivita(String nomeAttivita) {
		this.nomeAttivita = nomeAttivita;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public int getNumeroCivico() {
		return numeroCivico;
	}
	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
	public String getTipologiaAttivita() {
		return tipologiaAttivita;
	}
	public void setTipologiaAttivita(String tipologiaAttivita) {
		this.tipologiaAttivita = tipologiaAttivita;
	}
	public int getOraApertura() {
		return oraApertura;
	}
	public void setOraApertura(int oraApertura) {
		this.oraApertura = oraApertura;
	}
	public int getOraChiusura() {
		return oraChiusura;
	}
	public void setOraChiusura(int oraChiusura) {
		this.oraChiusura = oraChiusura;
	}
	public String[] getServizi() {
		return servizi;
	}
	public void setServizi(String[] servizi) {
		this.servizi = servizi;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}

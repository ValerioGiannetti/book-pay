package com.bookpay.cloud.entity;

public class ClientiRecensioniEntity {

	
	private Long fkIdCliente;
	private Long fkIdEsercente;
	private Long fkEsercenteNegozio;
	private String data;
	private String punteggio;

	public Long getFkIdCliente() {
		return fkIdCliente;
	}
	public void setFkIdCliente(Long fkIdCliente) {
		this.fkIdCliente = fkIdCliente;
	}
	public Long getFkIdEsercente() {
		return fkIdEsercente;
	}
	public void setFkIdEsercente(Long fkIdEsercente) {
		this.fkIdEsercente = fkIdEsercente;
	}
	public Long getFkEsercenteNegozio() {
		return fkEsercenteNegozio;
	}
	public void setFkEsercenteNegozio(Long fkEsercenteNegozio) {
		this.fkEsercenteNegozio = fkEsercenteNegozio;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(String punteggio) {
		this.punteggio = punteggio;
	}
	
	
}

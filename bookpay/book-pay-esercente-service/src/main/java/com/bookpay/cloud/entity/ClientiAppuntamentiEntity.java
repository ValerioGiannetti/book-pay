package com.bookpay.cloud.entity;

import javax.persistence.Entity;

@Entity
public class ClientiAppuntamentiEntity {

	private Long fkIdCliente;
	private Long fkIdEsercente;
	private Long fkIdEsercenteNegozio;
	private Long fkIdEsercenteNegozioStaff;
	private String data;
	private String oraInizio;
	private String oraFine;
	private String note;
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
	public Long getFkIdEsercenteNegozio() {
		return fkIdEsercenteNegozio;
	}
	public void setFkIdEsercenteNegozio(Long fkIdEsercenteNegozio) {
		this.fkIdEsercenteNegozio = fkIdEsercenteNegozio;
	}
	public Long getFkIdEsercenteNegozioStaff() {
		return fkIdEsercenteNegozioStaff;
	}
	public void setFkIdEsercenteNegozioStaff(Long fkIdEsercenteNegozioStaff) {
		this.fkIdEsercenteNegozioStaff = fkIdEsercenteNegozioStaff;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getOraInizio() {
		return oraInizio;
	}
	public void setOraInizio(String oraInizio) {
		this.oraInizio = oraInizio;
	}
	public String getOraFine() {
		return oraFine;
	}
	public void setOraFine(String oraFine) {
		this.oraFine = oraFine;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}

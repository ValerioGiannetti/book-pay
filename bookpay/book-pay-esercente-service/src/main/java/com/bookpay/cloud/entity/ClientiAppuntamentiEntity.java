package com.bookpay.cloud.entity;

import javax.persistence.Entity;

@Entity
public class ClientiAppuntamentiEntity {

	private ClientiEntity clientiEntity;
	private EsercenteEntity esercenteEntity;
	private EsercenteNegozioEntity esercenteNegozioEntity;
	private EsercenteStaffEntity esercenteStaffEntity;
	private String data;
	private String oraInizio;
	private String oraFine;
	private String note;
	
	
	
	public ClientiEntity getClientiEntity() {
		return clientiEntity;
	}
	public void setClientiEntity(ClientiEntity clientiEntity) {
		this.clientiEntity = clientiEntity;
	}
	public EsercenteEntity getEsercenteEntity() {
		return esercenteEntity;
	}
	public void setEsercenteEntity(EsercenteEntity esercenteEntity) {
		this.esercenteEntity = esercenteEntity;
	}
	public EsercenteNegozioEntity getEsercenteNegozioEntity() {
		return esercenteNegozioEntity;
	}
	public void setEsercenteNegozioEntity(EsercenteNegozioEntity esercenteNegozioEntity) {
		this.esercenteNegozioEntity = esercenteNegozioEntity;
	}
	public EsercenteStaffEntity getEsercenteStaffEntity() {
		return esercenteStaffEntity;
	}
	public void setEsercenteStaffEntity(EsercenteStaffEntity esercenteStaffEntity) {
		this.esercenteStaffEntity = esercenteStaffEntity;
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

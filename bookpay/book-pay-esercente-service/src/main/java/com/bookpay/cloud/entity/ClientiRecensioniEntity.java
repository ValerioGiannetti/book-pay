package com.bookpay.cloud.entity;

public class ClientiRecensioniEntity {

	
	private ClientiEntity clientiEntity;
	private EsercenteEntity esercenteEntity;
	private EsercenteNegozioEntity esercenteNegozioEntity;
	private String data;
	private String punteggio;
	
	
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

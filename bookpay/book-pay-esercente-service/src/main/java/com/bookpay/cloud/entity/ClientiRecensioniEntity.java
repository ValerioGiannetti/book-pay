package com.bookpay.cloud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "d_clienti_recensioni")
public class ClientiRecensioniEntity {

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private ClientiEntity clientiEntity;
	@ManyToOne
	@JoinColumn(name = "idEsercente")
	private EsercenteEntity esercenteEntity;
	@ManyToOne
	@JoinColumn(name = "idEsercenteNegozio")
	private EsercenteNegozioEntity esercenteNegozioEntity;
	@Id
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

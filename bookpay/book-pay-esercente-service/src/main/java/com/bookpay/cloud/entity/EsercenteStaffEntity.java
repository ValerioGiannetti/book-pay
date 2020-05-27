package com.bookpay.cloud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EsercenteStaffEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEsercenteNegozioStaff;
	private EsercenteEntity esercenteEntity;
	private EsercenteNegozioEntity esercenteNegozioEntity;
	
	private String nome;
	private String cognome;
	private String numeroAppuntamentiOra;
	
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
	public Long getIdEsercenteNegozioStaff() {
		return idEsercenteNegozioStaff;
	}
	public void setIdEsercenteNegozioStaff(Long idEsercenteNegozioStaff) {
		this.idEsercenteNegozioStaff = idEsercenteNegozioStaff;
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
	public String getNumeroAppuntamentiOra() {
		return numeroAppuntamentiOra;
	}
	public void setNumeroAppuntamentiOra(String numeroAppuntamentiOra) {
		this.numeroAppuntamentiOra = numeroAppuntamentiOra;
	}
	
	
	
	
}

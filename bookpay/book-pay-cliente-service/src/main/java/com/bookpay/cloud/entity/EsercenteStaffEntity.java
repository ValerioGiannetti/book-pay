package com.bookpay.cloud.entity;

public class EsercenteStaffEntity {

	private int fkIdEsercente;
	private int fkIdEsercenteNegozio;
	private int idEsercenteNegozioStaff;
	private String nome;
	private String cognome;
	private String numeroAppuntamentiOra;
	
	public int getFkIdEsercente() {
		return fkIdEsercente;
	}
	public void setFkIdEsercente(int fkIdEsercente) {
		this.fkIdEsercente = fkIdEsercente;
	}
	public int getFkIdEsercenteNegozio() {
		return fkIdEsercenteNegozio;
	}
	public void setFkIdEsercenteNegozio(int fkIdEsercenteNegozio) {
		this.fkIdEsercenteNegozio = fkIdEsercenteNegozio;
	}
	public int getIdEsercenteNegozioStaff() {
		return idEsercenteNegozioStaff;
	}
	public void setIdEsercenteNegozioStaff(int idEsercenteNegozioStaff) {
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

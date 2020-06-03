package com.book.cloud.dto;

public class DatiPrenotazioneDto {
	
	private String idEsercente;
	private String idEsercenteNegozio;
	private String idStaffNegozio;
	private String idCliente;
	
	
	private int minuti;
	private int ora;
	private String dataAppuntamento;
	private String note;
	
	public String getIdEsercente() {
		return idEsercente;
	}
	public void setIdEsercente(String idEsercente) {
		this.idEsercente = idEsercente;
	}
	public String getIdEsercenteNegozio() {
		return idEsercenteNegozio;
	}
	public void setIdEsercenteNegozio(String idEsercenteNegozio) {
		this.idEsercenteNegozio = idEsercenteNegozio;
	}
	public String getIdStaffNegozio() {
		return idStaffNegozio;
	}
	public void setIdStaffNegozio(String idStaffNegozio) {
		this.idStaffNegozio = idStaffNegozio;
	}
	public int getMinuti() {
		return minuti;
	}
	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}
	public int getOra() {
		return ora;
	}
	public void setOra(int ora) {
		this.ora = ora;
	}
	public String getDataAppuntamento() {
		return dataAppuntamento;
	}
	public void setDataAppuntamento(String dataAppuntamento) {
		this.dataAppuntamento = dataAppuntamento;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	
	

}

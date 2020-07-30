package com.bookpay.cloud.utility;

public class Prova1 {

	private String id;
	private String data;
	
	private String attivo;
	private String nome;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAttivo() {
		return attivo;
	}
	public void setAttivo(String attivo) {
		this.attivo = attivo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		String stmp = "DATA: "+this.data+" ATTIVO: "+this.attivo+" ID: "+this.id+" NOME: "+this.nome;
		return stmp;
	}
	
}

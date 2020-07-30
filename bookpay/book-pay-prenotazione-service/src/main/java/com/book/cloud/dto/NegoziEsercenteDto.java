package com.book.cloud.dto;

import java.util.HashSet;
import java.util.Set;

public class NegoziEsercenteDto {

	private String idNegoziEsercente;
	private String nome;
	private String via;
	private String cap;
	private String latitudine;
	private String longitudine;
	
	private Set<StaffDto>listaStaff = new HashSet<StaffDto>(0);

	public String getIdNegoziEsercente() {
		return idNegoziEsercente;
	}

	public void setIdNegoziEsercente(String idNegoziEsercente) {
		this.idNegoziEsercente = idNegoziEsercente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}

	public String getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}

	public Set<StaffDto> getListaStaff() {
		return listaStaff;
	}

	public void setListaStaff(Set<StaffDto> listaStaff) {
		this.listaStaff = listaStaff;
	}
	
	
	
}

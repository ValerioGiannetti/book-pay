package com.gateway.cloud.dto;

import java.util.HashSet;
import java.util.Set;

public class EsercenteDto extends UtenteDto{

	private String idEsercente;
	
	private String piva;
	private Set<NegoziEsercenteDto> listaNegozi = new HashSet<NegoziEsercenteDto>(0);
	
	public String getIdEsercente() {
		return idEsercente;
	}
	public void setIdEsercente(String idEsercente) {
		this.idEsercente = idEsercente;
	}
	public String getPiva() {
		return piva;
	}
	public void setPiva(String piva) {
		this.piva = piva;
	}
	public Set<NegoziEsercenteDto> getListaNegozi() {
		return listaNegozi;
	}
	public void setListaNegozi(Set<NegoziEsercenteDto> listaNegozi) {
		this.listaNegozi = listaNegozi;
	}
	
	
}

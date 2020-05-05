package com.gateway.cloud.model;

import org.springframework.security.core.GrantedAuthority;

public class Ruolo implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4621183438442781398L;
	private String codiceRuolo;
	private String idRuolo;
	
	
	
	public String getCodiceRuolo() {
		return codiceRuolo;
	}



	public void setCodiceRuolo(String codiceRuolo) {
		this.codiceRuolo = codiceRuolo;
	}



	public String getIdRuolo() {
		return idRuolo;
	}



	public void setIdRuolo(String idRuolo) {
		this.idRuolo = idRuolo;
	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}

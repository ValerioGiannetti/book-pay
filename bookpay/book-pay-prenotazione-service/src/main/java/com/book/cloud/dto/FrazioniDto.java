package com.book.cloud.dto;


public class FrazioniDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3124857654284375564L;
	private int id;
	private String istatComune;
	private String frazione;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIstatComune() {
		return istatComune;
	}
	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}
	public String getFrazione() {
		return frazione;
	}
	public void setFrazione(String frazione) {
		this.frazione = frazione;
	}
	
	
}

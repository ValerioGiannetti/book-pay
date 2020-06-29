package com.book.cloud.dto;


public class ProvincieDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372622800671076954L;
	private String sigla;
	private String provincia;
	private String superficie;
	private String residenti;
	private String numComuni;
	private String idRegione;
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getSuperficie() {
		return superficie;
	}
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	public String getResidenti() {
		return residenti;
	}
	public void setResidenti(String residenti) {
		this.residenti = residenti;
	}
	public String getNumComuni() {
		return numComuni;
	}
	public void setNumComuni(String numComuni) {
		this.numComuni = numComuni;
	}
	public String getIdRegione() {
		return idRegione;
	}
	public void setIdRegione(String idRegione) {
		this.idRegione = idRegione;
	}
	
	
	

	
}

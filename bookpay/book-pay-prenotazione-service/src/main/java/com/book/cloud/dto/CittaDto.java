package com.book.cloud.dto;

public class CittaDto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9182621814911605204L;
	private int istat;
	private String comune;
	private String regione;
	private String provincia;
	private String prefisso;
	private String codFisco;
	private String superficie;
	private String numResidenti;
	
	public int getIstat() {
		return istat;
	}
	public void setIstat(int istat) {
		this.istat = istat;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getRegione() {
		return regione;
	}
	public void setRegione(String regione) {
		this.regione = regione;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPrefisso() {
		return prefisso;
	}
	public void setPrefisso(String prefisso) {
		this.prefisso = prefisso;
	}
	public String getCodFisco() {
		return codFisco;
	}
	public void setCodFisco(String codFisco) {
		this.codFisco = codFisco;
	}
	public String getSuperficie() {
		return superficie;
	}
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	public String getNumResidenti() {
		return numResidenti;
	}
	public void setNumResidenti(String numResidenti) {
		this.numResidenti = numResidenti;
	}

	

}

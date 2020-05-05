package com.gateway.cloud.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Commerciante {

	private String id;
	private String nomeAttivita;
	private String nomeCommerciante;
	private String email;
	private Date dataRegistrazione;
	private Indirizzo indirizzo;
	private String password;
	private String idCategoriaMerceologica;
	private BigDecimal fasciaPrezzo;
	private String piva;
	private String sitoWeb;
	
	
	private boolean gestioneMagazzino;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeAttivita() {
		return nomeAttivita;
	}

	public void setNomeAttivita(String nomeAttivita) {
		this.nomeAttivita = nomeAttivita;
	}

	public String getNomeCommerciante() {
		return nomeCommerciante;
	}

	public void setNomeCommerciante(String nomeCommerciante) {
		this.nomeCommerciante = nomeCommerciante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isGestioneMagazzino() {
		return gestioneMagazzino;
	}

	public void setGestioneMagazzino(boolean gestioneMagazzino) {
		this.gestioneMagazzino = gestioneMagazzino;
	}


	public BigDecimal getFasciaPrezzo() {
		return fasciaPrezzo;
	}

	public void setFasciaPrezzo(BigDecimal fasciaPrezzo) {
		this.fasciaPrezzo = fasciaPrezzo;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getSitoWeb() {
		return sitoWeb;
	}

	public void setSitoWeb(String sitoWeb) {
		this.sitoWeb = sitoWeb;
	}

	public String getIdCategoriaMerceologica() {
		return idCategoriaMerceologica;
	}

	public void setIdCategoriaMerceologica(String idCategoriaMerceologica) {
		this.idCategoriaMerceologica = idCategoriaMerceologica;
	}


		
}

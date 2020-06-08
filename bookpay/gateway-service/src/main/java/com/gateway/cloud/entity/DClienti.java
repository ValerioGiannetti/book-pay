package com.gateway.cloud.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "d_clienti")
public class DClienti implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5522739010694300604L;
	
	private Integer idClienti;
	
	private DUtente DUtente;
	
	private String nome;
	
	private String cognome;
	
	private String via;
	
	private String cap;
	
	private String latitudine;
	
	private String longitudine;
	
	private Set<DPrenotazioni> DPrenotazionis = new HashSet<DPrenotazioni>(0);

	public DClienti() {
	}

	public DClienti(DUtente DUtente, String nome, String cognome, String via, String cap, String latitudine,
			String longitudine) {
		this.DUtente = DUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.cap = cap;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}

	public DClienti(DUtente DUtente, String nome, String cognome, String via, String cap, String latitudine,
			String longitudine, Set<DPrenotazioni> DPrenotazionis) {
		this.DUtente = DUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.cap = cap;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.DPrenotazionis = DPrenotazionis;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_clienti")
	public Integer getIdClienti() {
		return this.idClienti;
	}

	public void setIdClienti(Integer idClienti) {
		this.idClienti = idClienti;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_utente")
	public DUtente getDUtente() {
		return this.DUtente;
	}

	public void setDUtente(DUtente DUtente) {
		this.DUtente = DUtente;
	}
	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name = "cognome")
	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Column(name = "via")
	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}
	@Column(name = "cap")
	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}
	@Column(name = "latitudine")
	public String getLatitudine() {
		return this.latitudine;
	}

	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}
	@Column(name = "longitudine")
	public String getLongitudine() {
		return this.longitudine;
	}

	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}

	@OneToMany(mappedBy = "DClienti" ,fetch = FetchType.LAZY)
	public Set<DPrenotazioni> getDPrenotazionis() {
		return this.DPrenotazionis;
	}

	public void setDPrenotazionis(Set<DPrenotazioni> DPrenotazionis) {
		this.DPrenotazionis = DPrenotazionis;
	}

}


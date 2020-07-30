package com.bookpay.cloud.entity;


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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "d_negozi_esercente")
public class DNegoziEsercente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4092941859843737198L;
	
	
	private Integer idNegoziEsercente;
	private DEsercente DEsercente;
	private String nome;
	private String via;
	private String cap;
	private String latitudine;
	private String longitudine;
	private String codiceIstat;
	
	private Set<DStaffNegozio> DStaffNegozios = new HashSet<DStaffNegozio>(0);

	public DNegoziEsercente() {
	}

	public DNegoziEsercente(DEsercente DEsercente, String nome, String via, String cap, String latitudine,
			String longitudine) {
		this.DEsercente = DEsercente;
		this.nome = nome;
		this.via = via;
		this.cap = cap;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}

	public DNegoziEsercente(DEsercente DEsercente, String nome, String via, String cap, String latitudine,
			String longitudine, Set<DStaffNegozio> DStaffNegozios) {
		this.DEsercente = DEsercente;
		this.nome = nome;
		this.via = via;
		this.cap = cap;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.DStaffNegozios = DStaffNegozios;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_negozi_esercente")
	public Integer getIdNegoziEsercente() {
		return this.idNegoziEsercente;
	}

	public void setIdNegoziEsercente(Integer idNegoziEsercente) {
		this.idNegoziEsercente = idNegoziEsercente;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_esercente")
	public DEsercente getDEsercente() {
		return this.DEsercente;
	}

	public void setDEsercente(DEsercente DEsercente) {
		this.DEsercente = DEsercente;
	}
	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	@OneToMany(mappedBy = "DNegoziEsercente", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	public Set<DStaffNegozio> getDStaffNegozios() {
		return this.DStaffNegozios;
	}

	public void setDStaffNegozios(Set<DStaffNegozio> DStaffNegozios) {
		this.DStaffNegozios = DStaffNegozios;
	}
	@Column(name = "d_citta_istat")
	public String getCodiceIstat() {
		return codiceIstat;
	}

	public void setCodiceIstat(String codiceIstat) {
		this.codiceIstat = codiceIstat;
	}

}

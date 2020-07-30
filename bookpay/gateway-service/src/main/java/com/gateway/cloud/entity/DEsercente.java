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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "d_esercente")
public class DEsercente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3256531771437393625L;
	
	
	private Integer idEsercente;
	
	private DUtente DUtente;
	
	private String piva;
	
	
	private Set<DNegoziEsercente> DNegoziEsercentes = new HashSet<DNegoziEsercente>(0);

	public DEsercente() {
	}

	public DEsercente(DUtente DUtente, String piva) {
		this.DUtente = DUtente;
		this.piva = piva;
	}

	public DEsercente(DUtente DUtente, String piva, Set<DNegoziEsercente> DNegoziEsercentes) {
		this.DUtente = DUtente;
		this.piva = piva;
		this.DNegoziEsercentes = DNegoziEsercentes;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_esercente")
	public Integer getIdEsercente() {
		return this.idEsercente;
	}

	public void setIdEsercente(Integer idEsercente) {
		this.idEsercente = idEsercente;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_utente")
	@JsonIgnore
	public DUtente getDUtente() {
		return this.DUtente;
	}

	public void setDUtente(DUtente DUtente) {
		this.DUtente = DUtente;
	}
	@Column(name = "piva")
	public String getPiva() {
		return this.piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}
	
	@OneToMany(mappedBy = "DEsercente", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	public Set<DNegoziEsercente> getDNegoziEsercentes() {
		return this.DNegoziEsercentes;
	}

	public void setDNegoziEsercentes(Set<DNegoziEsercente> DNegoziEsercentes) {
		this.DNegoziEsercentes = DNegoziEsercentes;
	}

}

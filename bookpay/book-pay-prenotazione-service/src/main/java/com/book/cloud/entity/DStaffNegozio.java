package com.book.cloud.entity;

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
@Table(name = "d_staff_negozio")
public class DStaffNegozio implements java.io.Serializable {

	
	private static final long serialVersionUID = -8159531396751573310L;
	
	
	private Integer idStaffNegozio;
	
	private DNegoziEsercente DNegoziEsercente;
	
	private String nome;
	
	private String cognome;
	
	private String numeroAppuntamentiGiorno;
	
	
	private Set<DPrenotazioni> DPrenotazionis = new HashSet<DPrenotazioni>(0);

	public DStaffNegozio() {
	}

	public DStaffNegozio(DNegoziEsercente DNegoziEsercente, String nome, String cognome) {
		this.DNegoziEsercente = DNegoziEsercente;
		this.nome = nome;
		this.cognome = cognome;
	}

	public DStaffNegozio(DNegoziEsercente DNegoziEsercente, String nome, String cognome,
			String numeroAppuntamentiGiorno, Set<DPrenotazioni> DPrenotazionis) {
		this.DNegoziEsercente = DNegoziEsercente;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroAppuntamentiGiorno = numeroAppuntamentiGiorno;
		this.DPrenotazionis = DPrenotazionis;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_staff_negozio")
	public Integer getIdStaffNegozio() {
		return this.idStaffNegozio;
	}

	public void setIdStaffNegozio(Integer idStaffNegozio) {
		this.idStaffNegozio = idStaffNegozio;
	}
	@ManyToOne
	@JoinColumn(name = "fk_negozio")
	public DNegoziEsercente getDNegoziEsercente() {
		return this.DNegoziEsercente;
	}

	public void setDNegoziEsercente(DNegoziEsercente DNegoziEsercente) {
		this.DNegoziEsercente = DNegoziEsercente;
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
	@Column(name = "numero_appuntamenti_giorno")
	public String getNumeroAppuntamentiGiorno() {
		return this.numeroAppuntamentiGiorno;
	}

	public void setNumeroAppuntamentiGiorno(String numeroAppuntamentiGiorno) {
		this.numeroAppuntamentiGiorno = numeroAppuntamentiGiorno;
	}
	@OneToMany(mappedBy = "DStaffNegozio", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	public Set<DPrenotazioni> getDPrenotazionis() {
		return this.DPrenotazionis;
	}

	public void setDPrenotazionis(Set<DPrenotazioni> DPrenotazionis) {
		this.DPrenotazionis = DPrenotazionis;
	}

}
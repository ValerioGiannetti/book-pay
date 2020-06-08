package com.book.cloud.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "d_prenotazioni")
public class DPrenotazioni implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8788252611279174661L;
	
	private Integer idPrenotazioni;
	private DClienti DClienti;
	private DStaffNegozio DStaffNegozio;
	private String giorno;
	private String ora;
	private String minuti;
	private Date dataPrenotazione;
	
	
	public DPrenotazioni() {
	}

	public DPrenotazioni(DClienti DClienti, DStaffNegozio DStaffNegozio, String giorno, String ora, String minuti,
			Date dataPrenotazione) {
		this.DClienti = DClienti;
		this.DStaffNegozio = DStaffNegozio;
		this.giorno = giorno;
		this.ora = ora;
		this.minuti = minuti;
		this.dataPrenotazione = dataPrenotazione;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdPrenotazioni() {
		return this.idPrenotazioni;
	}

	public void setIdPrenotazioni(Integer idPrenotazioni) {
		this.idPrenotazioni = idPrenotazioni;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_clienti")
	public DClienti getDClienti() {
		return this.DClienti;
	}

	public void setDClienti(DClienti DClienti) {
		this.DClienti = DClienti;
	}
	@ManyToOne
	@JoinColumn(name = "fk_staff")
	public DStaffNegozio getDStaffNegozio() {
		return this.DStaffNegozio;
	}

	public void setDStaffNegozio(DStaffNegozio DStaffNegozio) {
		this.DStaffNegozio = DStaffNegozio;
	}
	@Column(name = "giorno")
	public String getGiorno() {
		return this.giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	@Column(name = "ora")
	public String getOra() {
		return this.ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}
	@Column(name = "minuti")
	public String getMinuti() {
		return this.minuti;
	}

	public void setMinuti(String minuti) {
		this.minuti = minuti;
	}
	@Column(name = "dataPrenotazione")
	public Date getDataPrenotazione() {
		return this.dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

}

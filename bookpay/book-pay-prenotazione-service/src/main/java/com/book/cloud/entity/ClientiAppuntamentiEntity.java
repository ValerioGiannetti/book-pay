package com.book.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "d_clienti_appuntamenti")
public class ClientiAppuntamentiEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente_appuntamenti")
	private Long idClienteAppuntamenti;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_cliente")
	private ClientiEntity clientiEntity;
	@ManyToOne
	@JoinColumn(name = "fk_id_esercente")
	private EsercenteEntity esercenteEntity;
	@ManyToOne(targetEntity = EsercenteNegozioEntity.class)
	@JoinColumn(name = "fk_id_esercenteNegozio")
	private EsercenteNegozioEntity esercenteNegozioEntity;
	@ManyToOne(targetEntity = EsercenteStaffEntity.class)
	@JoinColumn(name = "fk_id_esercenteNegozioStaff")
	private EsercenteStaffEntity esercenteStaffEntity;
	
	@Column(unique = true)
	private String data;
	private String ora;
	private String minuti;
	private String note;
	
	
	
	public ClientiEntity getClientiEntity() {
		return clientiEntity;
	}
	public void setClientiEntity(ClientiEntity clientiEntity) {
		this.clientiEntity = clientiEntity;
	}
	public EsercenteEntity getEsercenteEntity() {
		return esercenteEntity;
	}
	public void setEsercenteEntity(EsercenteEntity esercenteEntity) {
		this.esercenteEntity = esercenteEntity;
	}
	public EsercenteNegozioEntity getEsercenteNegozioEntity() {
		return esercenteNegozioEntity;
	}
	public void setEsercenteNegozioEntity(EsercenteNegozioEntity esercenteNegozioEntity) {
		this.esercenteNegozioEntity = esercenteNegozioEntity;
	}
	public EsercenteStaffEntity getEsercenteStaffEntity() {
		return esercenteStaffEntity;
	}
	public void setEsercenteStaffEntity(EsercenteStaffEntity esercenteStaffEntity) {
		this.esercenteStaffEntity = esercenteStaffEntity;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getIdClienteAppuntamenti() {
		return idClienteAppuntamenti;
	}
	public void setIdClienteAppuntamenti(Long idClienteAppuntamenti) {
		this.idClienteAppuntamenti = idClienteAppuntamenti;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public String getMinuti() {
		return minuti;
	}
	public void setMinuti(String minuti) {
		this.minuti = minuti;
	}
	
	
	
	
}

package com.book.cloud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

@Entity
@Table(name = "d_esercente")
public class EsercenteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_esercente")
	private Long idEsercente;
    private String nome;
    private String cognome;
    @Column(name = "data_nascita")
    private String dataNascita;
    
    private String email;
    private String telefono;
    private String indirizzo;
    private String civico;
    private String cap;
    private String citta;
    
    @OneToMany(mappedBy = "esercenteEntity",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<EsercenteNegozioEntity>listaNegozi;
	
    public Long getIdEsercente() {
		return idEsercente;
	}
	public void setIdEsercente(Long idEsercente) {
		this.idEsercente = idEsercente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public List<EsercenteNegozioEntity> getListaNegozi() {
		return listaNegozi;
	}
	public void setListaNegozi(List<EsercenteNegozioEntity> listaNegozi) {
		this.listaNegozi = listaNegozi;
	}
    
	
	public EsercenteNegozioEntity getNegozio(String idNegozio) {
		if(StringUtils.isNotEmpty(idNegozio)) {
			for (EsercenteNegozioEntity esercenteNegozioEntity : this.getListaNegozi()) {
				if(esercenteNegozioEntity.getIdEsercenteNegozio().equals(Long.valueOf(idNegozio))) {
					return esercenteNegozioEntity;
				}
			}
		}
		
		return null;
	}
	
	
    
}

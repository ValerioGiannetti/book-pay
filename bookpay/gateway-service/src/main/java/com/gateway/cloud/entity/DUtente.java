package com.gateway.cloud.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "d_utente")
public class DUtente implements UserDetails, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3685526577944889455L;
	
	private Integer idUtente;
	
	private String nome;
	
	private String email;
	
	private String password;
	
	private String attivo;
	
	private Date dataRegistrazione;
	
	private Date dataAttivazione;
	
	private DClienti cliente = new DClienti();
	
	private DEsercente esercente = new DEsercente();
	@Transient
	private List<String> ruoli;
	
	
	public DUtente() {
	}

	public DUtente(String nome, String email, String password, String attivo) {
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.attivo = attivo;
	}

	public DUtente(String nome, String email, String password, String attivo, Date dataRegistrazione,
			Date dataAttivazione, DClienti cliente, DEsercente esercente) {
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.attivo = attivo;
		this.dataRegistrazione = dataRegistrazione;
		this.dataAttivazione = dataAttivazione;
		this.cliente = cliente;
		this.esercente = esercente;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	public Integer getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "attivo")
	public String getAttivo() {
		return this.attivo;
	}

	public void setAttivo(String attivo) {
		this.attivo = attivo;
	}
	@Column(name = "data_registrazione")
	public Date getDataRegistrazione() {
		return this.dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	@Column(name = "data_attivazione")
	public Date getDataAttivazione() {
		return this.dataAttivazione;
	}

	public void setDataAttivazione(Date dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}
	
	@OneToOne(mappedBy = "DUtente")
	@JsonIgnore
	public DClienti getCliente() {
		return cliente;
	}

	public void setCliente(DClienti cliente) {
		this.cliente = cliente;
	}
	@OneToOne(mappedBy = "DUtente")
	public DEsercente getEsercente() {
		return esercente;
	}

	public void setEsercente(DEsercente esercente) {
		this.esercente = esercente;
	}

	public List<String> getRuoli() {
		String rc = "CLIENTE";
		String re = "ESERCENTE";
		
		setRuoli(new ArrayList<String>());
		
		this.ruoli.add(re);
		this.ruoli.add(rc);
		return ruoli;
	}

	public void setRuoli(List<String> ruoli) {
		this.ruoli = ruoli;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> aut = null;
		if(this.ruoli != null && !this.ruoli.isEmpty()) {
			 aut = new ArrayList<GrantedAuthority>();
			 
			 for (String ruolo : ruoli) {
				 GrantedAuthority ga = new SimpleGrantedAuthority(ruolo);
				 aut.add(ga);
			}
			 
		}
		
		return aut;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		if(StringUtils.isNotEmpty(String.valueOf(this.attivo) )) {
			if(String.valueOf(this.attivo).equals("Si")) {
				return true;
			}
			return false;
		}
		return false;
	}


}

package com.gateway.cloud.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document
public class Utenti implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1461146600485405710L;
	@Id
	private String id;
	@Indexed(unique = true)
	private String email;
	private String password;
	private String attivo;
	private String token;
	private List<String> ruoli;
	private boolean locked;
	
	private String idEsercente;
	private String idCliente;
	
	
	public String getIdEsercente() {
		return idEsercente;
	}
	public void setIdEsercente(String idEsercente) {
		this.idEsercente = idEsercente;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAttivo() {
		return attivo;
	}
	public void setAttivo(String attivo) {
		this.attivo = attivo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<String> getRuoli() {
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
		return this.locked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		if(StringUtils.isNotEmpty(this.attivo)) {
			if(this.attivo.equals("Si")) {
				return true;
			}
			return false;
		}
		return false;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	
	
	
	

}

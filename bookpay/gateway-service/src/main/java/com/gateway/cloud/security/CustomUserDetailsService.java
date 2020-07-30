package com.gateway.cloud.security;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gateway.cloud.entity.DUtente;
import com.gateway.cloud.repository.UtenteRepository;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UtenteRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		String errMsg = "";

		if (StringUtils.isEmpty(email) ) {
			errMsg = "Nome utente assente o non valido";
			logger.warn(errMsg);
			throw new UsernameNotFoundException(errMsg);
		}
		DUtente utente = repository.findByEmail(email); 
		if(utente == null) {
			errMsg = "Nome utente assente o non valido";
			logger.warn(errMsg);
			throw new UsernameNotFoundException(errMsg);
		}
		
		utente.setAttivo("Si");
		//utente.setLocked(true);
		UserBuilder builder = null;
		builder = org.springframework.security.core.userdetails.User.withUsername(utente.getEmail());
		builder.disabled((utente.getAttivo().equals("Si") ? false : true));
		builder.password(utente.getPassword());
		builder.username(utente.getEmail());
		String[] profili = utente.getRuoli().stream().map(a -> a).toArray(String[]::new);
		
		builder.authorities(profili);
		
		return utente;

	}


	public boolean checkPassword(String password, String passwordEncode) {
		
		if(passwordEncoder.matches(password, passwordEncode)) {
			
			if(StringUtils.isNotEmpty(repository.checkPassword(passwordEncode))) {
				return true;
			}
			
		}
		
		return false;
	}

}

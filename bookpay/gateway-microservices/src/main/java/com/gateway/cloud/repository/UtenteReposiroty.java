package com.gateway.cloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gateway.cloud.model.Utenti;

@Repository
public interface UtenteReposiroty extends MongoRepository<Utenti, String> {
	
	@Query(value = "{email:?0}")
	public Utenti findByEmail(String email);
	@Query(value = "{password:?0}",fields = "{'password' : 0}")
	public String checkPassword(String password);

}

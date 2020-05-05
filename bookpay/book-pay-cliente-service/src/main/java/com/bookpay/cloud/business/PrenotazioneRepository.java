package com.bookpay.cloud.business;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends MongoRepository<Prenotazione, String> {
	
	@Query(value = "{idCliente:?0}")
	public List<Prenotazione> findByIdCliente(String idCliente);

	
}

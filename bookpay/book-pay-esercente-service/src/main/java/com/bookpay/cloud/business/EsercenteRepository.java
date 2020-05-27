package com.bookpay.cloud.business;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
@Deprecated
public interface EsercenteRepository extends MongoRepository<Esercente, String> {

	
}

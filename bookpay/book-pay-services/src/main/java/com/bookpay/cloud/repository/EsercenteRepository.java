package com.bookpay.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookpay.cloud.entity.DEsercente;

@Repository
public interface EsercenteRepository extends CrudRepository<DEsercente, Integer>{
	
	@Query(value = "select * from d_esercente ",nativeQuery = true)
	public List<DEsercente> findByLatAndLong(String lat, String log);

}

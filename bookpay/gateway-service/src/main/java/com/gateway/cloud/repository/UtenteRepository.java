package com.gateway.cloud.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gateway.cloud.entity.DUtente;

@Repository
public interface UtenteRepository extends CrudRepository<DUtente, Long> {

	@Query(value = "select * from d_utente where email =:email",nativeQuery = true)
	public DUtente findByEmail(@Param("email") String email);
	@Query(value = "select password from d_utente where password =:password" ,nativeQuery = true)
	public String checkPassword(@Param("password")String password);

}

package com.bookpay.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookpay.cloud.entity.DUtente;

@Repository
public interface UtenteRepository extends CrudRepository<DUtente, Integer>{

}

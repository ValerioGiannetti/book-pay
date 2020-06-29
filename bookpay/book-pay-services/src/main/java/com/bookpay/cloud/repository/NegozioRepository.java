package com.bookpay.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookpay.cloud.entity.DNegoziEsercente;

@Repository
public interface NegozioRepository extends CrudRepository<DNegoziEsercente, Integer>{

}

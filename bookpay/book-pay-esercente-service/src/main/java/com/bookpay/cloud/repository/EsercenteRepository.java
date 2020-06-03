package com.bookpay.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookpay.cloud.entity.EsercenteEntity;

@Repository
public interface EsercenteRepository extends CrudRepository<EsercenteEntity, Long>{

}

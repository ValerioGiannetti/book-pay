package com.book.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.cloud.entity.DStaffNegozio;

@Repository
public interface StaffNegozioRepository extends CrudRepository<DStaffNegozio, Integer>{

}

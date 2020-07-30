package com.bookpay.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookpay.cloud.entity.DStaffNegozio;

@Repository
public interface StaffRepository extends CrudRepository<DStaffNegozio, Integer>{
	
	@Query(value = "select * from d_staff_negozio where fk_negozio =:idNegozio",nativeQuery = true)
	public List<DStaffNegozio> listaStaffByIdNegozio(Integer idNegozio);

}

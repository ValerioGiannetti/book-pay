package com.bookpay.cloud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpay.cloud.dto.StaffDto;
import com.bookpay.cloud.entity.DStaffNegozio;
import com.bookpay.cloud.repository.StaffRepository;
import com.bookpay.cloud.utility.SwapObject;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private StaffRepository repository;
	
	@Override
	public void saveStaff(StaffDto staffDto) {
		
		logger.info("inizio saveStaff");
		
		SwapObject<StaffDto, DStaffNegozio>swp = new SwapObject<StaffDto, DStaffNegozio>();
		DStaffNegozio target = new DStaffNegozio();
		try {
			
			swp.copyProperties(staffDto, target);
			
			repository.save(target);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		logger.info("fine saveStaff");
		
	}

	@Override
	public void deleteStaff(String idStaff) {
		
		logger.info("inizio deleteStaff");
		
		try {
			repository.deleteById(Integer.valueOf(idStaff));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		logger.info("fine deleteStaff");
		
	}

	@Override
	public void updateStaff(StaffDto dto) {
		
		logger.info("inizio updateStaff");
		try {
			
			Optional<DStaffNegozio> dStaffNegozio = repository.findById(Integer.valueOf(dto.getIdStaffNegozio()));
			
			dStaffNegozio.ifPresent(target->{
				
				repository.save(target);
				
			});
			
			
		}catch (Exception e) {
			// TODO: handle exception
			logger.info("errore "+e.getMessage());
		}
		
		
		logger.info("fine updateStaff");
		
	}
	
	public List<StaffDto>listaStaff(String idNegozioEsercente){
		
		logger.info("inizio listaStaff");
		
		List<StaffDto>output = new ArrayList<StaffDto>();
		
		try {
			List<DStaffNegozio> lista = repository.listaStaffByIdNegozio(Integer.valueOf(idNegozioEsercente));
			SwapObject<DStaffNegozio, StaffDto> swp = new SwapObject<DStaffNegozio, StaffDto>();
			if(lista != null && !lista.isEmpty()) {
				StaffDto target = null;
				for (DStaffNegozio source : lista) {
					
					target = new StaffDto();
					swp.copyProperties(source, target);
					output.add(target);
				}
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		logger.info("fine listaStaff");
		
		return output;
	}
	

}

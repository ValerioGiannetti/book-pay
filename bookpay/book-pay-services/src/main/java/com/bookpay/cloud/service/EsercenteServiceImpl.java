package com.bookpay.cloud.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpay.cloud.dto.EsercenteDto;
import com.bookpay.cloud.dto.NegoziEsercenteDto;
import com.bookpay.cloud.dto.StaffDto;
import com.bookpay.cloud.entity.DEsercente;
import com.bookpay.cloud.entity.DNegoziEsercente;
import com.bookpay.cloud.entity.DStaffNegozio;
import com.bookpay.cloud.entity.DUtente;
import com.bookpay.cloud.repository.EsercenteRepository;
import com.bookpay.cloud.utility.SwapObject;

@Service
@Transactional
public class EsercenteServiceImpl implements EsercenteService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EsercenteRepository repository;

	@Override
	public List<EsercenteDto> getListaLatAndLong(String lat, String log) {

		logger.info("inzio getListaLatAndLong");

		List<EsercenteDto> output = new ArrayList<EsercenteDto>();

		List<DEsercente> lista = repository.findByLatAndLong(lat, log);
		SwapObject<DEsercente, EsercenteDto> swp = new SwapObject<>();
		if (lista != null && !lista.isEmpty()) {
			try {
				for (DEsercente source : lista) {

					EsercenteDto target = new EsercenteDto();

					swp.copyProperties(source, target);

					output.add(target);

				}
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		logger.info("fine getListaLatAndLong");

		return output;
	}

	@Override
	public void registraEsercente(EsercenteDto esercenteDto) {

		SwapObject<EsercenteDto, DEsercente> swp = new SwapObject<EsercenteDto, DEsercente>();

		DEsercente dEsercente = new DEsercente();

		try {

			swp.copyProperties(esercenteDto, dEsercente);
			dEsercente.setDUtente(new DUtente());
			dEsercente.getDUtente().setCittaIstat(58059);
			dEsercente.getDUtente().setEmail(esercenteDto.getEmail());
			dEsercente.getDUtente().setNome(esercenteDto.getNome());
			dEsercente.getDUtente().setPassword("prova");
			dEsercente.getDUtente().setAttivo("N");
			dEsercente.getDUtente().setDataRegistrazione(Calendar.getInstance().getTime());
			dEsercente.getDUtente().setCliente(null);
			repository.save(dEsercente);

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<EsercenteDto> getLista() {
		logger.info("inzio getLista");

		List<EsercenteDto> output = new ArrayList<EsercenteDto>();

		Iterable<DEsercente> lista = repository.findAll();
		
		if (lista != null) {
			
			SwapObject<DEsercente, EsercenteDto> esercenteSwapper = new SwapObject<DEsercente, EsercenteDto>();
			SwapObject<DNegoziEsercente, NegoziEsercenteDto> negozioSwapper = new SwapObject<DNegoziEsercente, NegoziEsercenteDto>();
			SwapObject<DStaffNegozio, StaffDto> staffSwapper = new SwapObject<DStaffNegozio, StaffDto>();
			
			try {
				for (DEsercente source : lista) {

					EsercenteDto target = new EsercenteDto();

					esercenteSwapper.copyProperties(source, target);
					target.setAttivo(source.getDUtente().getAttivo());
					target.setNome(source.getDUtente().getNome());
					target.setEmail(source.getDUtente().getEmail());

					target.setListaNegozi(new HashSet<>());
					
					for (DNegoziEsercente sourceNegozio : source.getListaNegozi()) {
						
						NegoziEsercenteDto targetNegozio = new NegoziEsercenteDto();
						negozioSwapper.copyProperties(sourceNegozio, targetNegozio);
						target.getListaNegozi().add(targetNegozio);
						
						targetNegozio.setListaStaff(new HashSet<>());
						
						for (DStaffNegozio sourceStaff : sourceNegozio.getDStaffNegozios()) {
							
							StaffDto targetStaff = new StaffDto();
							staffSwapper.copyProperties(sourceStaff, targetStaff);
							
							targetNegozio.getListaStaff().add(targetStaff);
							
						}
						
					}
				
					output.add(target);

				}
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		logger.info("fine getLista");

		return output;
	}

}

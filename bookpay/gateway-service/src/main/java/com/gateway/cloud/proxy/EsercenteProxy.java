package com.gateway.cloud.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EsercenteBookPay",url = "")
public interface EsercenteProxy {
	
	@PostMapping(value = "/api/esercente/info-esercente/")
	public ResponseEntity<?> getInfoEsercente(@RequestParam(value = "jsonUt")String jsonUt);

}

package com.leonco.cloud.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CommerciantiLeoncoService",url = "http://localhost:7050")
public interface CommercianteProxy {
	@PostMapping(value = "/api/commerciante/info-commerciante/")
	public ResponseEntity<?>getInfoCommerciante(@RequestParam(value = "jsonUt")String jsonUt);
}

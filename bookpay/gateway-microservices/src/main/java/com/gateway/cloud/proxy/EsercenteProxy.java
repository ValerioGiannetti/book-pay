package com.gateway.cloud.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EsercenteBookPayService",url = "http://localhost:6050")
public interface EsercenteProxy {
	@PostMapping(value = "/api/commerciante/info-commerciante/")
	public ResponseEntity<?>getInfoCommerciante(@RequestParam(value = "jsonUt")String jsonUt);
}

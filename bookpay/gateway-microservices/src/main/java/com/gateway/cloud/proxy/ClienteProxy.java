package com.gateway.cloud.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ClienteBookPayService",url = "http://localhost:6050")
public interface ClienteProxy {
	
	@PostMapping("/api/gestione-cliente/info-cliente/")
	public ResponseEntity<?> getInfoCliente(@RequestParam(value = "jsonUt")String utJson);

}

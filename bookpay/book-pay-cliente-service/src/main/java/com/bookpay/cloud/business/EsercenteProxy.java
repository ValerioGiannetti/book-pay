package com.bookpay.cloud.business;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "EsercenteBookPayService",url = "http://localhost:6050")
public interface EsercenteProxy {

	
}

package com.bookpay.cloud.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "PrenotazioneBookPay",url = "")
public interface PrenotazioneProxy {

	
}

package com.bookpay.cloud.util;

import java.math.BigDecimal;

public class Prova3 {

	private BigDecimal idS;
	private String nomeS;
	
	public Prova3(){}
	
	public Prova3(BigDecimal idS,String nomeS) {
		
		this.idS = idS;
		this.nomeS = nomeS;
		
	}
	
	public BigDecimal getIdS() {
		return idS;
	}
	public void setIdS(BigDecimal idS) {
		this.idS = idS;
	}
	public String getNomeS() {
		return nomeS;
	}
	public void setNomeS(String nomeS) {
		this.nomeS = nomeS;
	}
	
	
}

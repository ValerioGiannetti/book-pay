package com.bookpay.cloud.util;

import java.util.Set;

public class Prova2 {

	private String id;
	private String nome;
	
	
	private Set<Prova4>lis1;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Prova4> getLis1() {
		return lis1;
	}
	public void setLis1(Set<Prova4> lis1) {
		this.lis1 = lis1;
	}
	
	@Override
	public String toString() {
		
		String concat = "";
		int conta = 1;
		for (Prova4 prova4 : lis1) {
			concat = prova4.getIdS()+" "+prova4.getNomeS();
			System.out.println("LISTA "+conta+" "+ concat);
			conta++;
		}
		
		return this.id +" "+ this.nome+" "+concat;
	}
	
	
}

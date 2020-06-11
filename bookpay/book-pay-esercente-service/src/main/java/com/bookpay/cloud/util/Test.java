package com.bookpay.cloud.util;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Test {

	public static void main(String[] args)  {
		SwapObject<Prova1, Prova2> swo = new SwapObject<>();
		
		Prova1 p1 = new Prova1();
		Prova2 p2 = new Prova2();
		
		
		p1.setId(1);
		p1.setNome("Valerio");
		p1.setLis1(new LinkedHashSet<>());
		p1.getLis1().add(new Prova3(new BigDecimal("8"), "Federica"));
		p1.getLis1().add(new Prova3(new BigDecimal("10"), "Valerio"));
		try {
			swo.copyProperties(p1, p2);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RISULTATO P2 "+p2.toString());
	}
}

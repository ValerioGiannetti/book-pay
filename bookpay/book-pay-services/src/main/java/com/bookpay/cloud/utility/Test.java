package com.bookpay.cloud.utility;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		
		
		
		Prova2 p2 = new Prova2();
		Prova3 p3 = new Prova3();
		p2.setId(1);
		p2.setData(Calendar.getInstance().getTime());
		
		p3.setAttivo("si");
		p3.setNome("Valerio");
		p2.setProva3(p3);
		
		Prova1 p1 = new Prova1();
		
		SwapObject<Prova2, Prova1> sw = new SwapObject<Prova2, Prova1>();
		
		try {
			sw.copyProperties(p2, p1);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(p1.toString());
	}
}

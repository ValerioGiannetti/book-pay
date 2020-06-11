package com.bookpay.cloud.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class SwapObject<S, T> {
	
	
	private T target;
	private S source;
	
	
	
	@SuppressWarnings("unchecked")
	public void copyProperties(S source, T target) throws IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException, SecurityException, InvocationTargetException {

		for (Method method : source.getClass().getDeclaredMethods()) {
			if (Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 0
					&& method.getReturnType() != void.class
					&& (method.getName().startsWith("get") || method.getName().startsWith("is"))) {
				
				Object value = method.invoke(source);
				S source1 = (S) value;
				
				if (value != null) {
					if(value.getClass().getName().equals(source.getClass().getName())) {
							
						copyProperties(source1, target);
						
					}
					String fieldName = method.getName().substring(3, method.getName().length());
					
					String temp = fieldName.substring(0, 1).toLowerCase();
				    String nameCapitalized = temp + fieldName.substring(1);
					System.out.println(fieldName + "=" + value);
					setField(target,nameCapitalized, value);
					
				}
			}
		}

	}

	/**
	 * Sets a field value on a given object
	 *
	 * @param targetObject Oggetto Target
	 * @param fieldName    nome property dell'oggetto
	 * @param fieldValue   valore per settare la property
	 * @return true se il valore è stato settato, false altrimenti
	 */
	@SuppressWarnings("unchecked")
	private  boolean setField(Object targetObject, String fieldName, Object fieldValue) {
		Field field;
		try {
			field = targetObject.getClass().getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			field = null;
		}
		Class<?> superClass = targetObject.getClass().getSuperclass();
		while (field == null && superClass != null) {
			try {
				field = superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				superClass = superClass.getSuperclass();
			}
		}
		if (field == null) {
			return false;
		}
		field.setAccessible(true);
		try {
			fieldValue.getClass().getTypeName();
			
			
			//TODO qui fare il valueOf
			if(field.getType().isAssignableFrom(String.class)) {

				if(fieldValue instanceof Integer) {
					
					Integer temp = (Integer) fieldValue;
					field.set(targetObject,String.valueOf(temp));
					
				}else if(fieldValue instanceof BigDecimal) {
					BigDecimal b = (BigDecimal) fieldValue;
					field.set(targetObject, b.toString());
				}else if(fieldValue instanceof Long) {
					Long l = (Long) fieldValue;
					field.set(targetObject, String.valueOf(l));
				}else {
					field.set(targetObject,fieldValue);
				}
				
			}else if(field.getType().isAssignableFrom(Set.class)) {
				 LinkedHashSet<?>listaS = (LinkedHashSet<?>) fieldValue;
				
				 ParameterizedType stringListType = (ParameterizedType)field.getGenericType();
			     Class<?> clazzTarget = (Class<?>) stringListType.getActualTypeArguments()[0];
			     
			     LinkedHashSet<T>listTarget = new LinkedHashSet<T>();
			     for (Object object : listaS) {
			    	 Object t = clazzTarget.newInstance();
				     target = (T) t;
			    	 source = (S) object;
			    	 copyProperties(source, target);
			    	 listTarget.add(target);
				}
			   
 				 field.set(targetObject,listTarget);
 				 
				
			}
		
		//	field.set(targetObject, fieldValue);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

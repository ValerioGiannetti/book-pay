package com.leonco.cloud.composite;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.leonco.cloud.proxy.CommercianteProxy;
/**
 * Per usare questa classe 
 * bisogna usare il costruttore con il parametro
 * @author Valerio
 *
 */
@Component
public class UserComposite {

	private String utJson;
	@Autowired
	private CommercianteProxy commercianteProxy;

	private String idCommerciante;
	private String idCliente;
	
	
	public UserComposite() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ResponseEntity<?> build(String utJson) {
		this.utJson = utJson;

		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(utJson.toString());
			this.idCommerciante = jsonObject.getString("idCommerciante");
			this.idCliente = jsonObject.getString("idCliente");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return callProxy();
	}

	private ResponseEntity<?> callProxy() {

		if (StringUtils.isNotEmpty(this.idCommerciante)) {
			return commercianteProxy.getInfoCommerciante(this.utJson);
		} else if (StringUtils.isNotEmpty(this.idCliente)) {
			return null;
		}

		return null;
	}

}

package com.gateway.cloud.composite;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gateway.cloud.proxy.ClienteProxy;
import com.gateway.cloud.proxy.EsercenteProxy;
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
	private EsercenteProxy esercenteProxy;
	@Autowired
	private ClienteProxy clienteProxy;

	private String idEsercente;
	private String idCliente;
	
	
	public UserComposite() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ResponseEntity<?> build(String utJson) {
		this.utJson = utJson;

		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(utJson.toString());
			this.idEsercente = jsonObject.getString("idEsercente");
			this.idCliente = jsonObject.getString("idCliente");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return callProxy();
	}

	private ResponseEntity<?> callProxy() {

		if (StringUtils.isNotEmpty(this.idEsercente)) {
			return esercenteProxy.getInfoCommerciante(this.utJson);
		} else if (StringUtils.isNotEmpty(this.idCliente)) {
			return clienteProxy.getInfoCliente(this.utJson);
		}

		return null;
	}

}

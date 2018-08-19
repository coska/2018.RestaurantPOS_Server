package com.coska.lab.restaurantpos.api.domain;

import java.util.HashMap;
import java.util.Map;

import com.coska.lab.expo.domain.MessageType;

public class ApiResponse {

	private String data;
	private MessageType type;
	private Map<String, String> errors;
	private Map<String, Object> datas;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	public void addError(String key, String message) {
		if(errors == null) errors = new HashMap<String, String>();
		errors.put(key, message);
	}
	
	public boolean hasError() {
		return (errors != null && errors.size() > 0) ? true: false;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public Map<String, Object> getDatas() {
		return datas;
	}
	
	public void addData(String key, String Object) {
		if(datas == null) datas = new HashMap<String, Object>();
		datas.put(key, Object);
	}
	
}

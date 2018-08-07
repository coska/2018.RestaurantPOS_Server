package com.coska.lab.restaurantpos.api.domain;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {

	private String data;
	private Map<String, String> errors;

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
}

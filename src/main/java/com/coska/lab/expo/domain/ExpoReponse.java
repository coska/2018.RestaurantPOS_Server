package com.coska.lab.expo.domain;

import java.util.Map;

public class ExpoReponse {
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

}

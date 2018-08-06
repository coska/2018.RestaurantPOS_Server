package com.coska.lab.expo.api;

import java.util.Map;

public class ExpoPushResponse {
	private String status;
	private String message;
	private Map<String, String> details;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, String> getDetails() {
		return details;
	}
	public void setDetails(Map<String, String> details) {
		this.details = details;
	}
	
	
	
}

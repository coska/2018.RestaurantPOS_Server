package com.coska.lab.expo.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageType {
	SUCCESS,
	READY_ORDER,
	CALL_FROM_KITCHEN;
	
	@JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }
	
	public String getName() {
		return this.name();
	}
}

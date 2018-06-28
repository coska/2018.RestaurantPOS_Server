package com.coska.lab.restaurantpos.api.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderTypes {
	NEW, COOKING, READY, SERVED;
	
	@JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }
}

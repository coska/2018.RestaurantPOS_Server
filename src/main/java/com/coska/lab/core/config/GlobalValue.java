package com.coska.lab.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalValue {

	public static String DATABASE;
	
	@Value("${base.image.url}")
    public void setDatabase(String db) {
        DATABASE = (db != null) ? db:"https://s3.ca-central-1.amazonaws.com/coska-restaurant-pos";
    }
	
}

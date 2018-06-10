package com.coska.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan("com.coska.lab")
@EnableJpaAuditing		// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
public class RestaurantPosServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantPosServerApplication.class, args);
	}
}

package com.coska.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.coska.lab")
@EnableJpaAuditing // https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
public class RestaurantPosServerApplication {
	static Logger  logger = LoggerFactory.getLogger(RestaurantPosServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestaurantPosServerApplication.class, args);

		while (true) {
			try {
//				Thread.sleep(1000 * 60 * 10);
				Thread.sleep(1000 * 2);
			} catch (InterruptedException e) {
			}

			RestTemplate restTemplate = new RestTemplate();

			final String URL = "https://tklab.herokuapp.com/time";
			try {
				String result = restTemplate.getForObject(URL,  String.class);
				if(result != null) {
					logger.info(result.substring(0,  10));
				} else {
					logger.info("No Result");
				}			
				
			} catch (Exception e) {
				logger.error(e.getMessage());
			};
		}
	}
}

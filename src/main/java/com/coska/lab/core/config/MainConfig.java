package com.coska.lab.core.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;


@Configuration
@ComponentScan(basePackages = "com.coska", excludeFilters = { @Filter(Configuration.class) })

// http://websystique.com/spring/spring-propertysource-value-annotations-example/
@PropertySources({
	@PropertySource(value="classpath:application.properties", ignoreResourceNotFound=false),
//	@PropertySource(value="classpath:spring.jpa.properties", ignoreResourceNotFound=false),	
	@PropertySource(value="classpath:local.properties", ignoreResourceNotFound=true)
})

@Import({ PersistenceContext.class})
public class MainConfig {
	

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment env;
	
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
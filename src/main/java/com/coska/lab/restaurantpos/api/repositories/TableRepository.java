package com.coska.lab.restaurantpos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coska.lab.restaurantpos.api.domain.ServTables;


// http://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
// https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
// http://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
// http://websystique.com/spring/spring-propertysource-value-annotations-example/
// http://websystique.com/spring-boot/spring-boot-angularjs-spring-data-jpa-crud-app-example/

@Repository
public interface TableRepository extends JpaRepository<ServTables, Long> {
	ServTables findByTableName(String tableName);
}

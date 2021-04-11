package com.union.salesmanagementcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SalesManagementCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagementCoreApplication.class, args);
	}

}

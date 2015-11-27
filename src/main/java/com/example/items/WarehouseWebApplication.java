package com.example.items;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@SpringBootApplication
@EntityScan("com.example.items")
@EnableJpaRepositories("com.example.items")
@PropertySource("classpath:db-config.properties")
public class WarehouseWebApplication {

	protected Logger logger = Logger.getLogger(WarehouseWebApplication.class
			.getName());

	public static void main(String[] args) {
		SpringApplication.run(WarehouseWebApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");
		DataSource dataSource = (new EmbeddedDatabaseBuilder()).build();

		logger.info("dataSource = " + dataSource);

		return dataSource;
	}
}

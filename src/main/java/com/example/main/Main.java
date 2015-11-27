package com.example.main;

import org.springframework.boot.SpringApplication;

public class Main {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "whs-server");

		SpringApplication.run(WarehouseServer.class, args);
	}

}

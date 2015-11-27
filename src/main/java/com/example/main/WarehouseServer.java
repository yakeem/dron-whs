package com.example.main;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.example.items.WarehouseWebApplication;
import com.example.items.ItemRepository;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(WarehouseWebApplication.class)
public class WarehouseServer {

	@Autowired
	protected ItemRepository itemRepository;

	protected Logger logger = Logger.getLogger(WarehouseServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "whs-service");

		SpringApplication.run(WarehouseServer.class, args);
	}
}

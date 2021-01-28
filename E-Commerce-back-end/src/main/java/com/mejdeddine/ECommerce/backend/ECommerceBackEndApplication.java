package com.mejdeddine.ECommerce.backend;

import com.mejdeddine.ECommerce.backend.model.Product;
import com.mejdeddine.ECommerce.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceBackEndApplication {

	public static void main(String[] args) {

		SpringApplication.run(ECommerceBackEndApplication.class, args);

	}

}

package com.devsuperior.bds04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({})
public class Bds04Application {

	public static void main(String[] args) {
		SpringApplication.run(Bds04Application.class, args);
	}

}

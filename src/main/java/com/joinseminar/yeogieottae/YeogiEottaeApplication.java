package com.joinseminar.yeogieottae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class YeogiEottaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(YeogiEottaeApplication.class, args);
	}

}

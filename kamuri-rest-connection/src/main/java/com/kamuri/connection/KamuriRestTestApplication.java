package com.kamuri.connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KamuriRestTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KamuriRestTestApplication.class, args);
	}

}

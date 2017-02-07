package com.parthsuresh.alfred;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.parthsuresh.alfred"})
public class AlfredApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlfredApplication.class, args);
	}
}
package com.ri2unify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RI2UnifyMigrationApplication {

	public static void main(String[] args) {
		System.out.println("Starting RI2Unify migration tool");
		System.setProperty("server.servlet.context-path", "/");
		SpringApplication.run(RI2UnifyMigrationApplication.class, args);
	}

}

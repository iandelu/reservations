package com.example.catalog;

import org.springframework.boot.SpringApplication;

public class TestReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.from(ReservationsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

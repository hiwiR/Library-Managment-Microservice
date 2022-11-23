package com.miu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BookQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookQueryServiceApplication.class, args);
	}

}

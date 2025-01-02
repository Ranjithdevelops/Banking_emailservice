package com.banking.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@ComponentScan(basePackages = {"com.banking"})
public class BankingEmailserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingEmailserviceApplication.class, args);
	}

}

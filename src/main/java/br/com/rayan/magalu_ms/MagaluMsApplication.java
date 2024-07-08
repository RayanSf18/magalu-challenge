package br.com.rayan.magalu_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MagaluMsApplication {
	public static void main(String[] args) {
		SpringApplication.run(MagaluMsApplication.class, args);
	}
}

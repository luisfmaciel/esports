package br.edu.infnet.esports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EsportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsportsApplication.class, args);
	}

}

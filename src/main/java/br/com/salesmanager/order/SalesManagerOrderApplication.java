package br.com.salesmanager.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
@EnableFeignClients
public class SalesManagerOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagerOrderApplication.class, args);
	}

}

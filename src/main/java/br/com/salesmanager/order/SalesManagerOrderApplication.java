package br.com.salesmanager.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class SalesManagerOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagerOrderApplication.class, args);
	}

}

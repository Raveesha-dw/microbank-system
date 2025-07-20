package com.springboot.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "RDW Loans Microservice REST API Documentation using Swagger Pages",
				version = "1.0.0",
				contact = @Contact(
						name = "Raveesha Weerasinghe",
						email = "raveesha.weerasinghe22@gmail.com",
						url = "https://github.com/raveesha-weerasinghe"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://springdoc.org"
				)
		)
//		externalDocs = @ExternalDocumentation(
//				description = "EazyBank Loans microservice REST API Documentation",
//				url = "https://www.eazybytes.com/swagger-ui.html"
//		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}

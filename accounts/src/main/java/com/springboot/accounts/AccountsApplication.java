package com.springboot.accounts;

import com.springboot.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.naming.Name;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.springboot.accounts.controller") })
@EnableJpaRepositories("com.springboot.accounts.repository")
@EntityScan("com.springboot.accounts.model")*/
//if packages are created not within the same folder -> Configure using annotations
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts Microservice REST API Documentation",
				description = "RDW Accounts Microservice REST API Documentation using Swagger Pages",
				version = "1.0.0",
				contact = @Contact(
						name = "Raveesha Weerasinghe",
						email = "raveesha.weerasinghe22@gmail.com",
						url = "https://github.com/raveesha-weerasinghe"
				),
				license = @License(name = "Apache 2.0", url = "http://springdoc.org")
//				externalDocs = @ExternalDocumentation(
//						description = "Spring Boot Microservice Documentation",
//						url = "https://spring.io/projects/spring-boot"
//				)
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}

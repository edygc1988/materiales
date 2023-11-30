package com.integra.materiales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.integra.materiales.config.RsaKeyProperties;

@Configuration
@EnableConfigurationProperties(RsaKeyProperties.class)
// The `@SpringBootApplication` annotation is a convenience annotation that combines three commonly
// used annotations in Spring Boot applications: `@Configuration`, `@EnableAutoConfiguration`, and
// `@ComponentScan`.
@SpringBootApplication
// The `@EntityScan("com.integra.materiales.model")` annotation is used to specify the package(s) where
// the entity classes are located. In this case, it is specifying that the entity classes for the
// application are located in the `com.integra.materiales.model` package.
@EntityScan("com.integra.materiales.model")
public class MaterialApplication {

	/**
	 * The main function is used to run the MaterialApplication class in a Spring Boot application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MaterialApplication.class, args);
	}
}

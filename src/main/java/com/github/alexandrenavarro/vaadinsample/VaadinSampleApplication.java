package com.github.alexandrenavarro.vaadinsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = {CountryResource.class})
public class VaadinSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaadinSampleApplication.class, args);
	}
}

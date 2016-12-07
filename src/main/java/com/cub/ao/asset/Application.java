package com.cub.ao.asset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
@ComponentScan("com.cub.ao.asset")
public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
}

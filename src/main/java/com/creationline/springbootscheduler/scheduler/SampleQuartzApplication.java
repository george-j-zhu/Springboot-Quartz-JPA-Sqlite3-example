package com.creationline.springbootscheduler.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.creationline.springbootscheduler.data.models" })
@EnableJpaRepositories(basePackages = "com.creationline.springbootscheduler.data.repositories")
public class SampleQuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleQuartzApplication.class, args);
	}

}
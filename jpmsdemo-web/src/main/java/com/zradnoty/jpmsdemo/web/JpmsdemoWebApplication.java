package com.zradnoty.jpmsdemo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.zradnoty.jpmsdemo.auth*", "com.zradnoty.jpmsdemo.web*"})
@EnableJpaRepositories(basePackages = {"com.zradnoty.jpmsdemo.data*"})
@EntityScan(basePackages={"com.zradnoty.jpmsdemo.data.model"})
public class JpmsdemoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpmsdemoWebApplication.class, args);
	}

}

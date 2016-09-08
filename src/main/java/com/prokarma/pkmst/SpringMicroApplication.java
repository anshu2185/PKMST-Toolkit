package com.prokarma.pkmst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import be.ordina.msdashboard.EnableMicroservicesDashboardServer;


@SpringBootApplication
@EnableConfigServer//enable for externalized configuration in a distributed system
@EnableEurekaServer//enable service discovery,typically multiple eureka server should be run simultaneously
public class SpringMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroApplication.class, args);
	}
}

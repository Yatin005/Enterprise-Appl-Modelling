package com.va.week7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//@EnableDiscoveryClient  
@EnableEurekaServer
@SpringBootApplication
public class Wk7MicroServiceEx2Application {

	public static void main(String[] args) {
		SpringApplication.run(Wk7MicroServiceEx2Application.class, args);
	}

}

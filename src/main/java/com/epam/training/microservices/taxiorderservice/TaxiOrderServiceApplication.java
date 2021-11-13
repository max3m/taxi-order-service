package com.epam.training.microservices.taxiorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TaxiOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxiOrderServiceApplication.class, args);
    }

}

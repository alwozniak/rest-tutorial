package com.alwozniak.resttutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;

/**
 * Main class of the web app.
 */
@EnableEntityLinks      // For HATEOAS support.
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)     // For HATEOAS support.
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Run Spring Boot application.
        SpringApplication.run(Application.class, args);
    }
}

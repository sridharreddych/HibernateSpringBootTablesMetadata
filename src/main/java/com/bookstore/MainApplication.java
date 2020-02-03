package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.extractTablesMetadata();

        };
    }
}


/*
 * 
 * 
 * How To Extract Tables Metadata

Description: This application is an example of using the Hibernate SPI, org.hibernate.integrator.spi.Integrator for extracting tables metadata.

Key points:

implement org.hibernate.integrator.spi.Integrator and override integrate() method to return metadata.getDatabase()
register this Integrator via LocalContainerEntityManagerFactoryBean
 * 
 * 
 * 
 */

package com.lydec.gestioncomptes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.lydec.gestioncomptes.model")
public class GestioncomptesApplication {

    public static void main(String[] args) {
        SpringApplication.run( GestioncomptesApplication.class, args);
    }

}

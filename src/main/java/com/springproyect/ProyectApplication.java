package com.springproyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Collections;

@SpringBootApplication
public class ProyectApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ProyectApplication.class, args);

        SpringApplication app = new SpringApplication(ProyectApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8090"));
        app.run(args);
    }

}

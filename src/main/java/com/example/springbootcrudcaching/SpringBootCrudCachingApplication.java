package com.example.springbootcrudcaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootCrudCachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudCachingApplication.class, args);
    }

}

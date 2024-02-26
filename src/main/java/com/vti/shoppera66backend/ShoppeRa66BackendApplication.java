package com.vti.shoppera66backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShoppeRa66BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppeRa66BackendApplication.class, args);
        System.out.println("SERVER IS READY...");
    }

}

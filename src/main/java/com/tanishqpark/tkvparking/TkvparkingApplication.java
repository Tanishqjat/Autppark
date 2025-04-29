package com.tanishqpark.tkvparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TkvparkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkvparkingApplication.class, args);
        System.out.println("TKV Parking Backend is running on http://localhost:8080");
    }
}

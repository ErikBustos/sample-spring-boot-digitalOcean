package com.example.sample_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SampleSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringBootApplication.class, args);
	}

	@GetMapping("/")
    public String hello() {
        return "Hello from Dockerized Spring Boot!";
    }

	@GetMapping("/test1")
    public String hello1() {
        return "This is my test1";
    }

	@GetMapping("/test2")
    public String hello2() {
        return "This is my test2!";
    }
}

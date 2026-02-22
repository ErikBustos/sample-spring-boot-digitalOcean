package com.example.sample_spring_boot;

import com.example.sample_spring_boot.entity.Account;
import com.example.sample_spring_boot.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class SampleSpringBootApplication {

    @Autowired
    private AccountRepo accountRepo;

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

    @GetMapping("/test3")
    public String hello3() {
        return "This is my test3!";
    }

    @GetMapping("/getAccount/{username}")
    public ResponseEntity<Account> getAccountByUsername(@PathVariable String username) {
        return accountRepo.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("getAllAccounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountRepo.findAll();

        if (accounts.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content if list is empty
        }

        return ResponseEntity.ok(accounts); // 200 OK with the list
    }
}

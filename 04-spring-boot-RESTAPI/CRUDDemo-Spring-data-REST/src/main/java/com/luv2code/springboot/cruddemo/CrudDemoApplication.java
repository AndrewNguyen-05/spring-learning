package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    //http://localhost:8080/api/employees?sort=firstName,asc
    //http://localhost:8080/api/employees?sort=firstName,lastName,desc
    //http://localhost:8080/api/employees?sort=firstName,asc
    //http://localhost:8080/api/employees?page=0&size=2&sort=firstName,lastName,asc
    //http://localhost:8080/api/employees?page=0&size=2
}

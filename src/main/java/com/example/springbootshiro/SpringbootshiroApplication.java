package com.example.springbootshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootshiro.mapper")
public class SpringbootshiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootshiroApplication.class, args);
    }
}

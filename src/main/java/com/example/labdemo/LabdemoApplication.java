package com.example.labdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.labdemo.mapper")
public class LabdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabdemoApplication.class, args);
    }

}

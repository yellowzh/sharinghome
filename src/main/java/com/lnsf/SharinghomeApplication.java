package com.lnsf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@MapperScan("com.lnsf.dao")
public class SharinghomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SharinghomeApplication.class, args);
    }

}

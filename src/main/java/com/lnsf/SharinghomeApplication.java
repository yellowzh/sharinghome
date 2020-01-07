package com.lnsf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.lnsf.dao")
@SpringBootApplication(scanBasePackages = "com.lnsf")
public class SharinghomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SharinghomeApplication.class, args);
    }

}

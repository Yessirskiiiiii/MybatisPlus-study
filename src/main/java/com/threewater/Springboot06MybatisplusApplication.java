package com.threewater;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.threewater.mapper")
public class Springboot06MybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06MybatisplusApplication.class, args);
    }

}

package com.muhayu.syjeongboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.muhayu.syjeongboard")
public class SyjeongBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyjeongBoardApplication.class, args);
    }
}

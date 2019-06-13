package com.jzl.center_web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class CenterWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CenterWebApplication.class, args);
    }

}

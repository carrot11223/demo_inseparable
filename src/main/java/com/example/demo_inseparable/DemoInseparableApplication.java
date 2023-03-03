package com.example.demo_inseparable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.demo_inseparable.mapper")
@SpringBootApplication
public class DemoInseparableApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoInseparableApplication.class, args);
	}

}

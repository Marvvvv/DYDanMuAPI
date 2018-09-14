package com.yukari;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yukari.mapper")
public class ApplicationRun {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRun.class, args);
	}
}

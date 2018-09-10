package com.yukari.dydanmuapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yukari.dydanmuapi.mapper")
public class DydanmuapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DydanmuapiApplication.class, args);
	}
}

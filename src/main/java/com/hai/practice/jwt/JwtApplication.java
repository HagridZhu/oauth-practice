package com.hai.practice.jwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan
@MapperScan("com.hai.practice.jwt.**.mapper")
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}

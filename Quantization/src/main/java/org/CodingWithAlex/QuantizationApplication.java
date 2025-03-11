package org.CodingWithAlex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.CodingWithAlex.mapper")
public class QuantizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuantizationApplication.class, args);
	}
}

package com.zhumian.groceryshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.zhumian.groceryshop.mapper")
public class GroceryshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryshopApplication.class, args);
	}
}

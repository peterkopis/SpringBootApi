package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {

		System.out.println("hola");
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/greet")
	public GreetResponse greet2(){
		return new GreetResponse("hello Everybody",22);
	}

	record GreetResponse(String greet,int i){}

}

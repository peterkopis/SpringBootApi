package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/articles")
public class DemoApplication {

	private final ArticleRepository articleRepository;

	public DemoApplication(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public static void main(String[] args) {

		System.out.println("hola");
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public List<Article>getArticles(){

		return articleRepository.findAll();
	}
	/*@GetMapping("/greet")
	public GreetResponse greet2(){
		return new GreetResponse("hello Everybody",22);
	}

	record GreetResponse(String greet,int i){}*/

}

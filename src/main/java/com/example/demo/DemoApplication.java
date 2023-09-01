package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

	@PostMapping
	public void addArticle( @RequestBody Article nuevoArticle){

		articleRepository.save(nuevoArticle);

	}

	@DeleteMapping("{idArticle}")
	public void deleteArticle(@PathVariable("idArticle") Integer articleId){

		articleRepository.deleteById(articleId);
	}

	@PutMapping("{idArticle}")
	public String changeArticle(@PathVariable("idArticle") Integer articleId,@RequestBody Article changedArticle){

		Article loadedarticle=  articleRepository.getReferenceById(articleId);
		changedArticle.setId(articleId);
		articleRepository.saveAndFlush(changedArticle);
		return "is Changed";


	}
	/*@GetMapping("/greet")
	public GreetResponse greet2(){
		return new GreetResponse("hello Everybody",22);
	}

	record GreetResponse(String greet,int i){}*/

}

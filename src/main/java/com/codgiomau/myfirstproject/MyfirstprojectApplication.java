package com.codgiomau.myfirstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codgiomau.myfirstproject.entities.Category;
import com.codgiomau.myfirstproject.repositories.CategoryRepository;

@SpringBootApplication
public class MyfirstprojectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyfirstprojectApplication.class, args);
	}

	//metodo utilizado para rodar no inicio da aplicacao atraves da implementacao do commandlinerunner
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(1L, "Electronics");
		Category cat2 = new Category(2L, "Books");
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		
		
		
	}

}

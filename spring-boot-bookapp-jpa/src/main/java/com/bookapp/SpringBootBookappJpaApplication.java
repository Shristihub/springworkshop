package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.BookDto;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBootBookappJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookappJpaApplication.class, args);
	}

	@Autowired
	private IBookService bookService;
	
	
	@Override
	public void run(String... args) throws Exception {
		//create a dto object
		BookDto bookDto =  new BookDto("Java", null, 670,"Kathy", "Tech");
		//call the method of service layer
		
	}

}

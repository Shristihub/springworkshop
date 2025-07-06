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
//		BookDto bookDto =  new BookDto("Java", null, 670,"Kathy", "Tech");
////		//call the method of service layer
//		bookService.addBook(bookDto);
//		
//		bookDto =  new BookDto("Angular", null, 1670,"Rakesh", "Tech");
//		bookService.addBook(bookDto);
//		
//		bookDto =  new BookDto("JSP in Action", null, 1280,"Kathy", "Tech");
//		bookService.addBook(bookDto);
//		
//		bookDto =  new BookDto("Leadership", null, 680,"Robin", "selfhelp");
//		bookService.addBook(bookDto);
		
		System.out.println();
		System.out.println("Get all");
		bookService.getAll().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By Id");
		BookDto nbookdto = bookService.getById(3);
		System.out.println(nbookdto);
		
		nbookdto.setPrice(840);
		nbookdto.setTitle("HeadFirst Jsp");
		//call update method
		bookService.updateBook(nbookdto);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

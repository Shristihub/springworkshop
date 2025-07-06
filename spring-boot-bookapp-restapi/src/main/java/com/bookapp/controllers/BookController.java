package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.BookDto;
import com.bookapp.service.IBookService;

@RestController
public class BookController {

	//call the service layer method
	// autowire the service interface
	@Autowired
	private IBookService bookService;
	
//	http://localhost:8080/books
	@PostMapping("/books")
	ResponseEntity<Void> addBook(@RequestBody BookDto bookDto) {
		//call the addBook method
		bookService.addBook(bookDto);
		return ResponseEntity.status(201).build();
	}
	
//	http://localhost:8080/books
	@PutMapping("/books")
	ResponseEntity<Void> updateBook(@RequestBody BookDto bookDto) {
		bookService.updateBook(bookDto);
		return ResponseEntity.status(201).build();
	}
//	http://localhost:8080/books/bookId/1
	@DeleteMapping("/books/bookId/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable int bookId) {
		bookService.deleteBook(bookId);
		return ResponseEntity.ok().build();
	}
	
//	http://localhost:8080/books
	@GetMapping("/books")
	ResponseEntity<List<BookDto>> getAll(){
		List<BookDto> bookDtos = bookService.getAll();
		//add headers
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookDtos);
		
	}
	
//	http://localhost:8080/books/bookId/1
	@GetMapping("/books/bookId/{bookId}")
	ResponseEntity<BookDto> getById(@PathVariable int bookId) {
		BookDto bookDto = bookService.getById(bookId);
		return ResponseEntity.ok().body(bookDto);
	}
}




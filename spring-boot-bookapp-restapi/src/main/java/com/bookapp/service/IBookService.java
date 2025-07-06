package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.BookDto;

public interface IBookService {
	
	
	//CRUD 
	void addBook(BookDto bookDto);
	void updateBook(BookDto bookDto);
	void deleteBook(int bookId);
	
	List<BookDto> getAll();
	BookDto getById(int bookId) throws BookNotFoundException;
	List<BookDto> getByAuthor(String author)throws BookNotFoundException;
}

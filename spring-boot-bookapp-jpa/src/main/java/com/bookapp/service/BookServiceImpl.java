package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookDto;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {

	private IBookRepository bookRepository;
	@Autowired
	private ModelMapper modelMapper;

	// autowired annotation not required
	public BookServiceImpl(IBookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public void addBook(BookDto bookDto) {
		// converting dto object to entity
		Book book = modelMapper.map(bookDto, Book.class);
		// no id so autogenerate the id and save the record
		// dto comes with id ->
//		  if any record in db is with this id ->update the record
//		  if no record in db is with this id ->save the record
		bookRepository.save(book);
	}
	@Override
	public void updateBook(BookDto bookDto) {
		// converting dto object to entity
		//dto object should come with id
		Book book = modelMapper.map(bookDto, Book.class);
		bookRepository.save(book);
	}
	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}
	@Override
	public List<BookDto> getAll() {
		List<Book> books = bookRepository.findAll();
//		List<BookDto> bookDtos = new ArrayList<>();
//		for (Book book : books) {
//			// converting entity object to bookdto
//			BookDto bookDto =  modelMapper.map(book, BookDto.class);
//			bookDtos.add(bookDto);
//		}
//		return bookDtos;
		
		// convert books to a stream
		return books.stream()
		      .map(book-> modelMapper.map(book, BookDto.class))
		      .collect(Collectors.toList());
		
	}

	@Override
	public BookDto getById(int bookId) throws BookNotFoundException {
		Book book = bookRepository.findById(bookId)
					.orElseThrow(()->new BookNotFoundException("invalid id"));
		return modelMapper.map(book, BookDto.class);
	}

	@Override
	public List<BookDto> getByAuthor(String author) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

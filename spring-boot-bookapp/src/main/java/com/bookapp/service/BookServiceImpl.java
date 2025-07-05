package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookUtil;

@Service
public class BookServiceImpl implements IBookService {

	
	private BookUtil bookUtil;
	
	@Autowired // injecting the dependencies
	public void setBookUtil(BookUtil bookUtil) {
		this.bookUtil = bookUtil;
	}

//	BookUtil butil = new BookUtil(); //@Component
//	BookServiceImpl bookServiceImpl = new BookServiceImpl();//@Service
//	bookServiceImpl.setBookUtil(butil);

	@Override
	public List<Book> getAll() {
		return bookUtil.showBooks();
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		// get the list of books
		List<Book> books = bookUtil.showBooks();
		// convert to streams
//		Optional<Book> bookopt = 
//				books.stream().filter(book -> book.getBookId() == bookId)
//				.findFirst();
//		if (bookopt.isPresent())
//			return bookopt.get();
//		return null;
		
		Book nbook = books.stream().filter(book -> book.getBookId() == bookId)
		     .findFirst()
		     .orElseThrow(()->new BookNotFoundException("invalid id"));
		return nbook;
		
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> books = bookUtil.showBooks();
		List<Book> booksByAuthor = books.stream().filter(book->book.getAuthor().equals(author))
			  .toList();
		if(booksByAuthor.isEmpty())
			throw new BookNotFoundException("author not found");
		return booksByAuthor;
	}

}

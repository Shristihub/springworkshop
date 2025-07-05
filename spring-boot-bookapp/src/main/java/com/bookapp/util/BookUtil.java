package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;

@Component
public class BookUtil {

	public List<Book> showBooks(){
		return Arrays.asList(
				new Book("HeadFirst Java",1,1200,"Kathy","Tech"),
				new Book("Leadership",2,560,"Robin","selfhelp"),
				new Book("HeadFirst JSP",3,800,"Kathy","Tech"),
				new Book("Monk",4,670,"Robin","selfhelp")
				);
	}
}

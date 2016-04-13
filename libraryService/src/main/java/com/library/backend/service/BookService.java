package com.library.backend.service;

import java.util.List;

import com.library.backend.model.Book;
import com.library.backend.model.Member;


public interface BookService {

	void createBookEntry(Book book);
	
	void deleteBookEntry(Book book);
	
	List<Book> findBooksByAuthor(String author);
	
	List<Book> findBooksByTitle(String title);
	
	void updateBook(Book book);
	
	void raiseBookRequest(Book book, Member member);
	
	void withdrawBookRequest(Book book, Member member);
	
	void approveBookRequest(Book book, Member member);
}
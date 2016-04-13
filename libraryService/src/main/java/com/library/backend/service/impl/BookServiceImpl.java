package com.library.backend.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.backend.dao.BookDao;
import com.library.backend.model.Book;
import com.library.backend.model.Member;
import com.library.backend.service.BookService;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	public void createBookEntry(Book book) {
		bookDao.createBookEntry(book);
	}

	public void deleteBookEntry(Book book) {
		bookDao.deleteBookEntry(book);
	}

	public List<Book> findBooksByAuthor(String author) {
		return bookDao.findBooksByAuthor(author);
	}

	public List<Book> findBooksByTitle(String title) {
		return bookDao.findBooksByTitle(title);
	}

	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	public void raiseBookRequest(Book book, Member member) {
		bookDao.raiseBookRequest(book, member);
	}

	public void approveBookRequest(Book book, Member member) {
		bookDao.approveBookRequest(book, member);
	}

	public void withdrawBookRequest(Book book, Member member) {
		bookDao.withdrawBookRequest(book, member);
		
	}

}

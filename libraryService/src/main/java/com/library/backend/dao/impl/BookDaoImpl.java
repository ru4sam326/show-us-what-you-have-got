package com.library.backend.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.library.backend.dao.impl.AbstractDao;
import com.library.backend.dao.BookDao;
import com.library.backend.model.Book;
import com.library.backend.model.Member;
import com.library.backend.model.PendingRequest;
import com.library.backend.model.ReservedBook;

@Repository("bookDao")
public class BookDaoImpl extends AbstractDao implements BookDao {

	public void createBookEntry(Book book) {
		persist(book);
	}

	public void deleteBookEntry(Book book) {
		delete(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> findBooksByAuthor(String author) {
		System.out.println("DAO author provided : " +  author);
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.ilike("author","%"+author+"%"));
		List<Book> list = criteria.list();
		System.out.println("List size : " + list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Book> findBooksByTitle(String title) {
		System.out.println("DAO author provided : " +  title);
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.ilike("title","%"+title+"%"));
		List<Book> list = criteria.list();
		System.out.println("List size : " + list.size());
		return list;
	}

	public void updateBook(Book book) {
		update(book);

	}

	public void raiseBookRequest(Book book, Member member) {
		PendingRequest pendingRequest = new PendingRequest();
		pendingRequest.setBookId(book.getBookId());
		pendingRequest.setDateOfRequest(new Date());
		pendingRequest.setMemberId(member.getMemberId());
		persist(pendingRequest);
	}

	public void withdrawBookRequest(Book book, Member member) {
		Calendar cal = Calendar.getInstance();
		PendingRequest pendingRequest = new PendingRequest();
		pendingRequest.setBookId(book.getBookId());
		pendingRequest.setDateOfRequest(cal.getTime());
		pendingRequest.setMemberId(member.getMemberId());
		delete(pendingRequest);
	}
	
	public void approveBookRequest(Book book, Member member) {
		Calendar cal = Calendar.getInstance();
		ReservedBook reservedBook =  new ReservedBook();
		reservedBook.setBookId(book.getBookId());
		reservedBook.setDateOfIssue(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, 15);
		reservedBook.setDateOfActualReturn(cal.getTime());
		reservedBook.setMemberId(member.getMemberId());
		persist(reservedBook);
		
		//updating the available copies
		book.setAvailableCopies(book.getAvailableCopies());
		update(book);
		
		//delete the pending request
		withdrawBookRequest(book,member);
	}

}

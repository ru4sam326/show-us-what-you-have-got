package com.library.backend.model;

public class BookRequestWrapper {
	
	private Book book;
	private Member member;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	
}

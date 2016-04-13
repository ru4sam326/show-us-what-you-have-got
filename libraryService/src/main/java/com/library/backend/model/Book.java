package com.library.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;

	@Column(name = "title", nullable = false, length = 400)
	private String title;

	@Column(name = "author", nullable = false, length = 400)
	private String author;

	@Column(name = "isbn_num", length = 600)
	private String isbnNumber;

	@Column(name = "typeOfAvailability", nullable = false, length = 400)
	private String typeOfAvailability;

	@Column(name = "total_copies_available", nullable = false)
	private int totalCopies;

	@Column(name = "current_available_copies", nullable = false)
	private int availableCopies;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getTypeOfAvailability() {
		return typeOfAvailability;
	}

	public void setTypeOfAvailability(String typeOfAvailability) {
		this.typeOfAvailability = typeOfAvailability;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}

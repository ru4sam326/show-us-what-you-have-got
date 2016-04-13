package com.library.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PENDING_BOOK_REQUESTS")
public class PendingRequest {

	@Id
	@Column(name = "request_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestId;

	@Column(name = "requested_on", nullable = false)
	private Date dateOfRequest;

	@Column(name = "member_id", nullable = false)
	private int memberId;

	@Column(name = "book_id", nullable = false)
	private int bookId;

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

}

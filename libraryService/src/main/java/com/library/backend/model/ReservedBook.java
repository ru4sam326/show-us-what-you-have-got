package com.library.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENTLY_RESERVED_BOOKS")
public class ReservedBook {

	@Id
	@Column(name = "reservation_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reservationId;

	@Column(name = "issued_on", nullable = false)
	private Date dateOfIssue;

	@Column(name = "actual_return_date", nullable = false)
	private Date dateOfActualReturn;

	@Column(name = "return_date", nullable = false)
	private Date dateOfReturn;

	@Column(name = "book_id", nullable = false)
	private int bookId;

	@Column(name = "member_id", nullable = false)
	private int memberId;

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDateOfActualReturn() {
		return dateOfActualReturn;
	}

	public void setDateOfActualReturn(Date dateOfActualReturn) {
		this.dateOfActualReturn = dateOfActualReturn;
	}

	public Date getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

}

/**
 * 
 */
package com.assignment3.groupd.model;

import java.sql.Date;

/**
 * Date: 23.02.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * Model class for borrow table
 */
public class BorrowD {
	private int bookId;
	private int memberId;
	private Date issueDate;
	private Date returnDate;
	private Date dueDate;
	private String bookName;
	private String memberName;

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

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}

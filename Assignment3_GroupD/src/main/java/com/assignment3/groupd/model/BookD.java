/**
 * 
 */
package com.assignment3.groupd.model;

/**
 * Date: 23.02.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * Model class for Book table
 */
public class BookD {
	private int bookId;
	private int pubId;
	private String title;
	private String author;
	private String available;
	private double price;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getPubId() {
		return pubId;
	}

	public void setPubId(int pubId) {
		this.pubId = pubId;
	}

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

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

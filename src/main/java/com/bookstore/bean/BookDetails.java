package com.bookstore.bean;

import java.io.Serializable;

public class BookDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1450252897638356990L;
	
	private int bookId;
	private String bookName;
	private double bookPrice;
	private boolean active;
	private int authorId;
	private String authorName;
	private String address;
	
	public BookDetails() {
		
	}

	public BookDetails(int bookId, String bookName, double bookPrice, boolean active, int authorId, String authorName,
			String address) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.active = active;
		this.authorId = authorId;
		this.authorName = authorName;
		this.address = address;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "[bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", active="
				+ active + ", authorId=" + authorId + ", authorName=" + authorName + ", address=" + address + "]";
	}
	
	
}

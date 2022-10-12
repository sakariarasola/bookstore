package com.example.domain;

public class Book {

	private String title;
	private String author;
	private long year;
	private long isbn;
	private int price;

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

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}
	
	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Title [title=" + title + "]";
	}
}

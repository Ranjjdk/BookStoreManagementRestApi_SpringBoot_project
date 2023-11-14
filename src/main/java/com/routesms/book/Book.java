package com.routesms.book;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	private String bookTitle;
	private String language;
	private Long price;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	
     public Book() {
    	 
     }
	
	public Book(Long bookId, String bookTitle, String language, Long price,Author author) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.language = language;
		this.price = price;
		this.author=author;
	}



	public Long getBookId() {
		return bookId;
	}



	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}



	public String getBookTitle() {
		return bookTitle;
	}



	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public Long getPrice() {
		return price;
	}



	public void setPrice(Long price) {
		this.price = price;
	}



	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", language=" + language + ", price=" + price
				+ ", author=" + author + "]";
	}
	
	
	
	

}

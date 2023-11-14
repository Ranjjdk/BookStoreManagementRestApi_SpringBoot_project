package com.routesms.book;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
	
	
	private String authorName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long authorId;
	private String language;
	
	@JsonBackReference
	@OneToOne(mappedBy = "author")
	private Book book;
	
	public Author() {
		
	}
	
	public Author(String authorName, Long authorId, String language, Book book) {

		this.authorName = authorName;
		this.authorId = authorId;
		this.language = language;
		this.book = book;
	}
	

	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	

}

package com.bookstore.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authorId ;
	
	private String authName;
	
	@OneToMany(mappedBy="author",cascade= CascadeType.ALL)
	private List <Book> books;

	public Author() {
		super();
	}

	public Author(Long authorId, String authName, List<Book> books) {
		super();
		this.authorId = authorId;
		this.authName = authName;
		this.books = books;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authName=" + authName + "]";
	}
	
	
}

package com.isra.springmongo.dto;

import java.io.Serializable;
import java.util.List;

import com.isra.springmongo.domain.Book;
import com.isra.springmongo.domain.BookStore;
import com.isra.springmongo.domain.User;

public class BookStoreDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private List<User> user;
	private List<Book> book;
	
	public BookStoreDTO() {
	}
	
	public BookStoreDTO(BookStore obj) {
		id = obj.getId();
		name = obj.getName();
		user = obj.getUser();
		book = obj.getBooks();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	
	

}

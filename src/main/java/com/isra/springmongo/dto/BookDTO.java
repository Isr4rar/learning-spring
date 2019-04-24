package com.isra.springmongo.dto;

import com.isra.springmongo.domain.Book;

public class BookDTO {
	
	private String id;
	private String name;
	private String autor;
	private Integer ano;
	
	public BookDTO() {
	}

	public BookDTO(Book obj) {
		id = obj.getId();
		name = obj.getName();
		autor = obj.getAutor();
		ano = obj.getAno();
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
	
}

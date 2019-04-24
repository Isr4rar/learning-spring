package com.isra.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isra.springmongo.domain.Book;
import com.isra.springmongo.dto.BookDTO;
import com.isra.springmongo.repository.BookRepository;
import com.isra.springmongo.services.exception.ObjectNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public List<Book> findAll(){
		return repo.findAll();
	}
	
	public Book findById(String id) {
		Optional<Book> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public Book insert(Book obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public Book update(Book obj) {
		Book newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	
	private void updateData(Book newObj, Book obj) {
		newObj.setName(obj.getName());
		newObj.setAutor(obj.getAutor());
		newObj.setAno(obj.getAno());
	}

	public Book fromDTO(BookDTO objDto) {
		return new Book(objDto.getId(), objDto.getName(), objDto.getAutor(),objDto.getAno());
	}
}

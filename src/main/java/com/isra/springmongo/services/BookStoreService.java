package com.isra.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isra.springmongo.domain.BookStore;
import com.isra.springmongo.dto.BookStoreDTO;
import com.isra.springmongo.repository.BookStoreRepository;
import com.isra.springmongo.services.exception.ObjectNotFoundException;

@Service
public class BookStoreService {
	
	@Autowired
	private BookStoreRepository repo;
	
	public List<BookStore> findAll(){
		return repo.findAll();
	}
	
	public BookStore findById(String id) {
		Optional<BookStore> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public BookStore insert(BookStore obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public BookStore update(BookStore obj) {
		BookStore newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	
	private void updateData(BookStore newObj, BookStore obj) {
		newObj.setName(obj.getName());
		newObj.setUser(obj.getUser());
		newObj.setBook(obj.getBook());
	}

	public BookStore fromDTO(BookStoreDTO objDto) {
		return new BookStore(objDto.getId(), objDto.getName());
	}
}

package com.isra.springmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isra.springmongo.domain.BookStore;
import com.isra.springmongo.dto.BookStoreDTO;
import com.isra.springmongo.services.BookStoreService;

@RestController
@RequestMapping(value="/bookstore")
public class BookStoreResource {
	
	@Autowired
	private BookStoreService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BookStoreDTO>>  findAll(){
		List<BookStore> list = service.findAll();
		List<BookStoreDTO> listDto = list.stream().map(x -> new BookStoreDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<BookStoreDTO>  findById(@PathVariable String id){
		BookStore obj = service.findById(id);
		return ResponseEntity.ok().body(new BookStoreDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>  insert(@RequestBody BookStoreDTO objDto){
		BookStore obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.DELETE)
	public ResponseEntity<Void>  delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void>  update(@RequestBody BookStoreDTO objDto, @PathVariable String id){
		BookStore obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
}

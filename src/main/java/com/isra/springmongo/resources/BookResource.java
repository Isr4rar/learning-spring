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

import com.isra.springmongo.domain.Book;
import com.isra.springmongo.dto.BookDTO;
import com.isra.springmongo.services.BookService;

@RestController
@RequestMapping(value="/books")
public class BookResource {
	
	@Autowired
	private BookService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BookDTO>>  findAll(){
		List<Book> list = service.findAll();
		List<BookDTO> listDto = list.stream().map(x -> new BookDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<BookDTO>  findById(@PathVariable String id){
		Book obj = service.findById(id);
		return ResponseEntity.ok().body(new BookDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>  insert(@RequestBody BookDTO objDto){
		Book obj = service.fromDTO(objDto);
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
	public ResponseEntity<Void>  update(@RequestBody BookDTO objDto, @PathVariable String id){
		Book obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}

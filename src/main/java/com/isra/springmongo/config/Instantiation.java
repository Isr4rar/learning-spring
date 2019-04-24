package com.isra.springmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.isra.springmongo.domain.Book;
import com.isra.springmongo.domain.BookStore;
import com.isra.springmongo.domain.User;
import com.isra.springmongo.repository.BookRepository;
import com.isra.springmongo.repository.BookStoreRepository;
import com.isra.springmongo.repository.UserRepository;

@Configuration
public class Instantiation  implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookStoreRepository bookStoreRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		bookRepository.deleteAll();
		bookStoreRepository.deleteAll();
		
		
		Book book_1 = new Book(null, "Star Wars - Marcas da Guerra", "Wendig, Chuck", 2015);
		Book book_2 = new Book(null, "Star Wars - Darth Plagueis", "Luceno, James", 2012);
		Book book_3 = new Book(null, "Star Wars - Troopers da Morte", "Schreiber, Joe", 2015);
		
		bookRepository.saveAll(Arrays.asList(book_1, book_2, book_3));
		
		User israel = new User(null, "Maria Eduarda", "Duda@gmail.com");
		User gabriel = new User(null, "Gabriel Araujo", "gabriel@gmail.com");
		User lucas = new User(null, "Lucas Araujo", "lucas@gmail.com");
		
		
		userRepository.saveAll(Arrays.asList(israel, gabriel, lucas));
		
		BookStore livraria = new BookStore(null, "Livraria Digivox");
		livraria.getBooks().addAll(Arrays.asList(book_1,book_2,book_3));
		livraria.getUser().addAll(Arrays.asList(israel, gabriel, lucas));
		
		bookStoreRepository.saveAll(Arrays.asList(livraria));
		
	}

}

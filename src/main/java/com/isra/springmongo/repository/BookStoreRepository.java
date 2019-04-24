package com.isra.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isra.springmongo.domain.BookStore;

@Repository
public interface BookStoreRepository extends MongoRepository<BookStore, String> {

}

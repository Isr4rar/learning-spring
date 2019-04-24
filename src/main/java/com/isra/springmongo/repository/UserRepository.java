package com.isra.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isra.springmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

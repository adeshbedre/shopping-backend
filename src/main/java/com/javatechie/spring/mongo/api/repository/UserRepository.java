package com.javatechie.spring.mongo.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongo.api.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

	List<User> findByName(String name);

}

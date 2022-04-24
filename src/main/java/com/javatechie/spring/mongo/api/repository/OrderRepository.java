package com.javatechie.spring.mongo.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongo.api.model.Order;
import com.javatechie.spring.mongo.api.model.User;

public interface OrderRepository extends MongoRepository<Order, Integer>{

	List<Order> findByUserName(String name);
	
}

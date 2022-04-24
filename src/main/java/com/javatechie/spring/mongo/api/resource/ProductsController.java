package com.javatechie.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.api.dto.FetchOrder;
import com.javatechie.spring.mongo.api.dto.ResponseDTO;
import com.javatechie.spring.mongo.api.model.Order;
import com.javatechie.spring.mongo.api.model.Products;
import com.javatechie.spring.mongo.api.model.User;
import com.javatechie.spring.mongo.api.repository.OrderRepository;
import com.javatechie.spring.mongo.api.repository.ProductsRepository;
import com.javatechie.spring.mongo.api.repository.UserRepository;

@RestController
public class ProductsController {

	@Autowired
	private ProductsRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@PostMapping("/addProduct")
	public String saveBook(@RequestBody Products book) {
		repository.save(book);
		return "Added book with id : ";
	}

	@GetMapping("/findAllBooks")
	public List<Products> getBooks() {
		return repository.findAll();
	}

	@GetMapping("/findAllBooks/{id}")
	public Optional<Products> getBook(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "book deleted with id : " + id;
	}

	@GetMapping("/findAllProducts")
	public List<Products> findAllProducts() {
		return repository.findAll();
	}
	

	@PostMapping("/register-user")
	public ResponseDTO<String> registerUser(@RequestBody User user) {
		User u = userRepository.save(user);
		System.out.println("the id is "+u.getId());
		return new ResponseDTO<String>("user created",null,null);
	}
	
	@PostMapping("/login")
	public ResponseDTO<String> login(@RequestBody User user) {
		List<User> list = userRepository.findByName(user.getName());
		System.out.println("user is "+list);
		if(!list.isEmpty()) {
			User db = list.get(0);
			if(user.getPassword().equals(db.getPassword())) {
				return new ResponseDTO<String>(null,null,null);
			}
		}
		ResponseDTO<String> res = new ResponseDTO<String>(null,"404","INVALID_USER");
		res.setStatusCode("404");
		res.setStatusMsg("INVALID_USER");
		return res;
	}
	
	
	@PostMapping("/order-place")
	public ResponseDTO<String> placeOrder(@RequestBody Order order) {
		Order u = orderRepository.save(order);
		System.out.println("the id is "+u.getId());
		return new ResponseDTO<String>("user created",null,null);
	}
	
	@PostMapping("/fetch-order")
	public ResponseDTO<List<Order>> placeOrder(@RequestBody FetchOrder fetchOrder) {
		List<Order> order = orderRepository.findByUserName(fetchOrder.getUserName());
		System.out.println("order is "+order);
		return new ResponseDTO<List<Order>>(order,null,null);
	}
	
}

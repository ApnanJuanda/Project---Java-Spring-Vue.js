package com.example.crudCustomer.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crudCustomer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
	Customer findBy_id(ObjectId _id);
}

package com.example.crudCustomer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudCustomer.model.Customer;
import com.example.crudCustomer.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;
	
	//Create Data
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		customer.set_id(ObjectId.get());
		customerRepository.save(customer);
		return customer;
	}
	
	//getAllData
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	
	//getDataBy_id
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable("id") ObjectId id) {
		return customerRepository.findBy_id(id);
	}
	
	//update/Edit Data
	@PutMapping("/customer/{id}")
	public ResponseEntity < Customer > updateCustomer(@PathVariable(value = "id") ObjectId id, @Valid @RequestBody Customer customerDetails) {
		Customer customer = customerRepository.findBy_id(id);
		customer.setNama(customerDetails.getNama() != null ? customerDetails.getNama() : customer.getNama());
		customer.setJabatan(customerDetails.getJabatan() != null ? customerDetails.getJabatan() : customer.getJabatan());
		customer.setGender(customerDetails.getGender() != null ? customerDetails.getGender() : customer.getGender());
		final Customer customerUpdated = customerRepository.save(customer);
		return ResponseEntity.ok(customerUpdated);
	}
	
	//deleteDataBy_Id
	@DeleteMapping("/customer/{id}")
    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") ObjectId id){
		Customer customer = customerRepository.findBy_id(id);
		customerRepository.delete(customer);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted data with id: " + id, Boolean.TRUE);
        return response;
    }
	

	
}

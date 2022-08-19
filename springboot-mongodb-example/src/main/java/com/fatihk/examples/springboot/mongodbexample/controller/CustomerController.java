package com.fatihk.examples.springboot.mongodbexample.controller;

import com.fatihk.examples.springboot.mongodbexample.model.Customer;
import com.fatihk.examples.springboot.mongodbexample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomers(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        if(firstName != null) {
            if (lastName != null)
                return ResponseEntity.ok(customerRepository.findCustomerByNameAndLastName(firstName, lastName));
            else {
                return ResponseEntity.ok(customerRepository.findCustomerByName(firstName));
            }
        }
        else if(lastName != null){
            return ResponseEntity.ok(customerRepository.findCustomerByLastName(lastName));
        }
        else{
            return ResponseEntity.ok(new ArrayList<>());
        }
    }

}

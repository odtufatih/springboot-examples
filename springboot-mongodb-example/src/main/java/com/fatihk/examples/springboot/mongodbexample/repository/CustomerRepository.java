package com.fatihk.examples.springboot.mongodbexample.repository;

import com.fatihk.examples.springboot.mongodbexample.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String>{

    @Query("{firstName:'?0'}")
    List<Customer> findCustomerByName(String name);

    @Query("{lastName:'?0'}")
    List<Customer> findCustomerByLastName(String lastName);

    @Query("{firstName:'?0', lastName:'?1'}")
    List<Customer> findCustomerByNameAndLastName(String name, String lastName);

}

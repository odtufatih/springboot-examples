package com.fatihk.examples.springboot.paginationexample.controller;

import com.fatihk.examples.springboot.paginationexample.model.User;
import com.fatihk.examples.springboot.paginationexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //RequestParam variables are required by default.
    //If page parameter is not sent in the url http 400 error will occur.
    //http://localhost:8080/users?pagesize=10&page=0
    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(@RequestParam(defaultValue = "5") int pagesize, @RequestParam int page){
        Pageable pageable = PageRequest.of(page, pagesize);
        return ResponseEntity.ok(userRepository.findAll(pageable));
    }

    //Another option is directly using a Pageable argument.
    // size and page variable names should be used in the url, default values will be used otherwise
    // http://localhost:8080/users/p?size=10&page=1
    // You can also sort by using any field of User
    // http://localhost:8080/users/p?size1=10&page=0&sort=registrationDate
    @GetMapping("/p")
    public ResponseEntity<Page<User>> pagination(Pageable pageable){
        return ResponseEntity.ok(userRepository.findAll(pageable));
    }

    //This option maybe better in terms of performance since it does not use a count query on the table
    // http://localhost:8080/users/slice?size1=10&page=0
    @GetMapping("/slice")
    public ResponseEntity<Slice<User>> slice(Pageable pageable){
        return ResponseEntity.ok(userRepository.findAll(pageable));
    }


}

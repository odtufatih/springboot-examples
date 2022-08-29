package com.fatihk.examples.springboot.paginationexample.repository;

import com.fatihk.examples.springboot.paginationexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

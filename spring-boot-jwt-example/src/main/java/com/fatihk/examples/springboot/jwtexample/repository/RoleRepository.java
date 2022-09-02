package com.fatihk.examples.springboot.jwtexample.repository;

import com.fatihk.examples.springboot.jwtexample.model.Role;
import com.fatihk.examples.springboot.jwtexample.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleName name);

}

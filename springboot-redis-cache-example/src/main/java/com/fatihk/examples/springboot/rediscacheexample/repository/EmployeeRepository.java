package com.fatihk.examples.springboot.rediscacheexample.repository;

import com.fatihk.examples.springboot.rediscacheexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}

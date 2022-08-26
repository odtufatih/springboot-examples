package com.fatihk.examples.springboot.rediscacheexample.service;

import com.fatihk.examples.springboot.rediscacheexample.model.Employee;
import com.fatihk.examples.springboot.rediscacheexample.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Cache only popular employees
     * unless attribute is evaluated after method execution, #result represents the returning employee object
     * The employee object will be cached only if isPopular==true
     */
    @Cacheable(cacheNames = "popularEmployeeCache", key = "#id", unless = "#result.isPopular==false")
    public Employee findById(Long id) {
        log.info("findById is called");
        return employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Cacheable(cacheNames = "getAllEmployees")
    public List<Employee> getAllEmployees() {
        log.info("getAllEmployees is called");
        return employeeRepository.findAll();
    }

    //refresh the cache object when it is updated
    @CachePut(value = "popularEmployeeCache", key = "#employee.id", condition = "#employee.isPopular==true")
    public Employee updateEmployee(Employee employee) {
        //here a logic to remove the employee from cache should be added if the employee is
        // being updated as isPopular=false while it was previously true, otherwise it will continue to come from cache with old data
        employeeRepository.findById(employee.getId()).orElseThrow(IllegalArgumentException::new);
        return employeeRepository.save(employee);
    }
}

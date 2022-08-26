package com.fatihk.examples.springboot.rediscacheexample;

import com.fatihk.examples.springboot.rediscacheexample.model.Employee;
import com.fatihk.examples.springboot.rediscacheexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCacheExampleApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Employee employee = new Employee(1L, "John Doe", 12, true);
        employeeService.save(employee);
        employee = new Employee(2L, "Martin Fowler", 12, false);
        employeeService.save(employee);
        employee = new Employee(3L, "Alex Brown", 17, false);
        employeeService.save(employee);
    }
}

package com.fatihk.examples.springboot.aopexample.controller;

import com.fatihk.examples.springboot.aopexample.model.Student;
import com.fatihk.examples.springboot.aopexample.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getAllStudents(@PathVariable String id){
        int index = Integer.valueOf(id)-1;
        return studentService.getStudent(index);
    }

}

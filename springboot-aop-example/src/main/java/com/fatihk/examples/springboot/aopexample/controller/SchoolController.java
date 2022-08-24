package com.fatihk.examples.springboot.aopexample.controller;

import com.fatihk.examples.springboot.aopexample.model.School;
import com.fatihk.examples.springboot.aopexample.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public List<School> getAllSchools(){
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    public School getSchool(@PathVariable String id){
        int index = Integer.valueOf(id)-1;
        return schoolService.getSchool(index);
    }

}

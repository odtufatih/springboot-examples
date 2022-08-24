package com.fatihk.examples.springboot.aopexample.service;

import com.fatihk.examples.springboot.aopexample.model.School;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {

    private final List<School> schools = new ArrayList<>();

    @PostConstruct
    public void init(){
        schools.add(new School(1, "Ortadoğu Teknik Üniversitesi", "Ankara"));
        schools.add(new School(2, "Bilkent Üniversitesi", "Ankara"));
        schools.add(new School(3, "İstanbul Teknik Üniversitesi", "İstanbul"));
        schools.add(new School(4, "Boğaziçi Üniversitesi", "İstanbul"));
    }


    public List<School> getAllSchools() {
        return schools;
    }

    public School getSchool(int id) {
        return schools.get(id);
    }
}

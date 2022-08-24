package com.fatihk.examples.springboot.aopexample.service;

import com.fatihk.examples.springboot.aopexample.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init(){
        students.add(new Student(1, "Ahmet Yılmaz", LocalDate.of(1999, 1, 17)));
        students.add(new Student(2, "Mete Karahan", LocalDate.of(2000, 9, 19)));
        students.add(new Student(3, "Teoman Kaya", LocalDate.of(2001, 3, 5)));
        students.add(new Student(4, "Sedat Gök", LocalDate.of(2001, 7, 28)));
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

}

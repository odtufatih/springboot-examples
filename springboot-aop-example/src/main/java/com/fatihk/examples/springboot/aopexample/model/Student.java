package com.fatihk.examples.springboot.aopexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private long studentId;

    private String studentName;

    private LocalDate birthDate;

}

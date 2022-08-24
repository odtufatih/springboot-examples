package com.fatihk.examples.springboot.aopexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    private long id;

    private String name;

    private String city;

}

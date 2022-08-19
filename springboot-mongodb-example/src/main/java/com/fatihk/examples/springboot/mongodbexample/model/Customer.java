package com.fatihk.examples.springboot.mongodbexample.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

//@ToString(exclude = {"id", "dateOfBirth"})
@Getter
@Setter
@Document(collection = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;

    private String customerNo;

    private String firstName;

    private String lastName;

    // Important: if @NoArgsConstructor is not added above, this format annotation does not work
    @JsonFormat(pattern = "ddMMyyyy")
    private Date dateOfBirth;
    //It would be better to use String type for dateOfBirth to not face with timezone issues in mongodb. We could store the birthday info as a string in ddMMyyyy format

    private Address homeAddress;

    private Address workAddress;

    private String[] hobbies;

    private List<Language> languages;

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    public static class Address{
        private String city;
        private String county;
        private String district;
        private int zipCode;
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    public static class Language{
        private String name;
        private String degree;
    }

    @CreatedDate
    private Date createDate;

}

package com.fatihk.examples.springboot.paginationexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    private Long id;

    @Column(length = 20)
    @NotNull
    private String username;

    @Column(length = 8)
    private String password;

    private LocalDateTime registrationDate;

}

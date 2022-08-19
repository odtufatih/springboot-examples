package com.fatihk.examples.springboot.postgresqlexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {

    private long id;

    private String firstName;

    private String lastName;

    private long teamId;

    private boolean active;

}

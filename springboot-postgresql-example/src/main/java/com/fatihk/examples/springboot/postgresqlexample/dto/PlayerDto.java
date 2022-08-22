package com.fatihk.examples.springboot.postgresqlexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {

    private long id;

    @NotBlank(message="firstName is mandatory")
    private String firstName;

    @NotBlank(message="lastName is mandatory")
    private String lastName;

    @Min(value = 1, message = "teamId must be positive")
    private long teamId;

    private boolean active;

}

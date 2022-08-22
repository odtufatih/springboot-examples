package com.fatihk.examples.springboot.postgresqlexample.dto;

import com.fatihk.examples.springboot.postgresqlexample.model.League;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {

    private long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @Min(value=1800, message = "Invalid foundingYear value")
    private int foundingYear;

    @Min(value=1, message = "leagueId must be greater than zero")
    private long leagueId;

}

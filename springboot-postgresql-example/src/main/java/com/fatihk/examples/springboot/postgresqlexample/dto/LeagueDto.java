package com.fatihk.examples.springboot.postgresqlexample.dto;

import com.fatihk.examples.springboot.postgresqlexample.model.League;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeagueDto {

    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private League.LeagueType leagueType;

}

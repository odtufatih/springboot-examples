package com.fatihk.examples.springboot.postgresqlexample.dto;

import com.fatihk.examples.springboot.postgresqlexample.model.League;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeagueDto {

    private long id;

    private String name;

    private League.LeagueType leagueType;
}

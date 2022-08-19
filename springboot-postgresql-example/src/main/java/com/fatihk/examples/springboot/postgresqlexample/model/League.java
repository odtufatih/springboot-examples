package com.fatihk.examples.springboot.postgresqlexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="leagues")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "league_id_seq")
    private int id;

    @Column
    private String name;

    @Column
    @Enumerated
    private LeagueType leagueType;

    public enum LeagueType{
        PRO,
        AMATEUR
    }
}

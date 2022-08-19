package com.fatihk.examples.springboot.postgresqlexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name="teams")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_seq")
    private long id;

    @Column(length=20)
    private String name;

    @Column
    private int foundingYear;

    @Column(name="league_id")
    private int leagueId;

}

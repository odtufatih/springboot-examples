package com.fatihk.examples.springboot.postgresqlexample.repository;

import com.fatihk.examples.springboot.postgresqlexample.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByLeagueId(int leagueId);

}

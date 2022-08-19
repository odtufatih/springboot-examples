package com.fatihk.examples.springboot.postgresqlexample.repository;

import com.fatihk.examples.springboot.postgresqlexample.model.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Integer> {
    
}

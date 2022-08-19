package com.fatihk.examples.springboot.postgresqlexample.repository;

import com.fatihk.examples.springboot.postgresqlexample.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    public List<Player> findByTeamId(Long teamId);

}

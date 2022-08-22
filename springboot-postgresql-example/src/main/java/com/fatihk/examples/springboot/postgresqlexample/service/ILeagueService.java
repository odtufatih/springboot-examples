package com.fatihk.examples.springboot.postgresqlexample.service;

import com.fatihk.examples.springboot.postgresqlexample.dto.LeagueDto;

import java.util.List;

public interface ILeagueService {

    public LeagueDto createLeague(LeagueDto leagueDto);

    public List<LeagueDto> getAllLeagues();

    public LeagueDto updateLeague(int id, LeagueDto leagueDto);

    public void deleteLeague(int id);

}

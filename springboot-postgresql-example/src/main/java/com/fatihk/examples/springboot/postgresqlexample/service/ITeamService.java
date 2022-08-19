package com.fatihk.examples.springboot.postgresqlexample.service;

import com.fatihk.examples.springboot.postgresqlexample.dto.TeamDto;

import java.util.List;

public interface ITeamService {

    public TeamDto createTeam(TeamDto team);

    public List<TeamDto> getAllTeams();

    public TeamDto updateTeam(long id, TeamDto leagueDto);

    void deleteTeam(long id);

    List<TeamDto> getTeamsByLeagueId(int id);
}

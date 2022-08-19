package com.fatihk.examples.springboot.postgresqlexample.service.impl;

import com.fatihk.examples.springboot.postgresqlexample.dto.LeagueDto;
import com.fatihk.examples.springboot.postgresqlexample.dto.TeamDto;
import com.fatihk.examples.springboot.postgresqlexample.exception.ResourceNotFoundException;
import com.fatihk.examples.springboot.postgresqlexample.model.League;
import com.fatihk.examples.springboot.postgresqlexample.model.Team;
import com.fatihk.examples.springboot.postgresqlexample.repository.TeamRepository;
import com.fatihk.examples.springboot.postgresqlexample.service.ITeamService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService implements ITeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    @Override
    public TeamDto createTeam(TeamDto teamDto){
        Team team = modelMapper.map(teamDto, Team.class);
        team = teamRepository.save(team);
        teamDto.setId(team.getId());
        return teamDto;
    }

    @Override
    public List<TeamDto> getAllTeams(){
        List<Team> teams = teamRepository.findAll();
        List<TeamDto> teamDtos = new ArrayList<>();
        teams.forEach( team -> {
            teamDtos.add(modelMapper.map(team, TeamDto.class));
        });
        return teamDtos;
    }

    @Override
    public TeamDto updateTeam(long id, TeamDto teamDto) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No team with id:" + id));
        teamDto.setId(id);
        modelMapper.map(teamDto, team);
        teamRepository.save(team);
        return teamDto;
    }

    @Override
    public void deleteTeam(long id) {
        teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No team with id:" + id));
        teamRepository.deleteById(id);
    }

    @Override
    public List<TeamDto> getTeamsByLeagueId(int id) {
        List<Team> teams = teamRepository.findByLeagueId(id);
        List<TeamDto> teamDtos = new ArrayList<>();
        teams.forEach( team -> {
            teamDtos.add(modelMapper.map(team, TeamDto.class));
        });
        return teamDtos;
    }


}

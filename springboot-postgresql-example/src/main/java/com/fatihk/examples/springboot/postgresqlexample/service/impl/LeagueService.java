package com.fatihk.examples.springboot.postgresqlexample.service.impl;

import com.fatihk.examples.springboot.postgresqlexample.dto.LeagueDto;
import com.fatihk.examples.springboot.postgresqlexample.exception.ResourceNotFoundException;
import com.fatihk.examples.springboot.postgresqlexample.model.League;
import com.fatihk.examples.springboot.postgresqlexample.repository.LeagueRepository;
import com.fatihk.examples.springboot.postgresqlexample.service.ILeagueService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueService implements ILeagueService {

    private final ModelMapper modelMapper;
    private final LeagueRepository leagueRepository;

    @Override
    public LeagueDto createLeague(LeagueDto leagueDto) {
        League league = modelMapper.map(leagueDto, League.class);
        league = leagueRepository.save(league);
        leagueDto.setId(league.getId());
        return leagueDto;
    }

    @Override
    public List<LeagueDto> getAllLeagues(){
        List<League> leagues = leagueRepository.findAll();
        List<LeagueDto> leagueDtos = new ArrayList<>();
        leagues.forEach( league -> {
            leagueDtos.add(modelMapper.map(league, LeagueDto.class));
        });
        return leagueDtos;
    }

    @Override
    public LeagueDto updateLeague(int id, LeagueDto leagueDto) {
        League league = leagueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No league with id:" + id));
        leagueDto.setId(id);
        modelMapper.map(leagueDto, league);
        leagueRepository.save(league);
        return leagueDto;
    }

    @Override
    public void deleteLeague(int id) {
        leagueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No league with id:" + id));
        leagueRepository.deleteById(id);
    }

}

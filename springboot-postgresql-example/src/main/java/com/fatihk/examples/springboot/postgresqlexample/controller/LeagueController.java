package com.fatihk.examples.springboot.postgresqlexample.controller;

import com.fatihk.examples.springboot.postgresqlexample.dto.LeagueDto;
import com.fatihk.examples.springboot.postgresqlexample.dto.TeamDto;
import com.fatihk.examples.springboot.postgresqlexample.service.ILeagueService;
import com.fatihk.examples.springboot.postgresqlexample.service.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leagues")
@RequiredArgsConstructor
public class LeagueController {

    private final ILeagueService leagueService;
    private final ITeamService teamService;

    @PostMapping
    public ResponseEntity<LeagueDto> createLeague(@RequestBody LeagueDto leagueDto){
        return new ResponseEntity<>(leagueService.createLeague(leagueDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LeagueDto>> getAllLeagues(){
        return ResponseEntity.ok(leagueService.getAllLeagues());
    }

    @GetMapping("/{id}/teams")
    public ResponseEntity<List<TeamDto>> getLeagueTeams(@PathVariable int id){
        return ResponseEntity.ok(teamService.getTeamsByLeagueId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeagueDto> updateLeague(@PathVariable("id") int id, @RequestBody LeagueDto leagueDto){
        return new ResponseEntity<>(leagueService.updateLeague(id, leagueDto), HttpStatus.OK);
    }

}

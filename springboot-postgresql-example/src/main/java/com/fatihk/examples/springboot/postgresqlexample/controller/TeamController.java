package com.fatihk.examples.springboot.postgresqlexample.controller;

import com.fatihk.examples.springboot.postgresqlexample.dto.LeagueDto;
import com.fatihk.examples.springboot.postgresqlexample.dto.PlayerDto;
import com.fatihk.examples.springboot.postgresqlexample.dto.TeamDto;
import com.fatihk.examples.springboot.postgresqlexample.service.IPlayerService;
import com.fatihk.examples.springboot.postgresqlexample.service.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final ITeamService teamService;
    private final IPlayerService playerService;

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody @Valid TeamDto team){
        team = teamService.createTeam(team);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams(){
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<List<PlayerDto>> getTeamPlayers(@PathVariable long id){
        return ResponseEntity.ok(playerService.getPlayersByTeamId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateLeague(@PathVariable("id") int id, @RequestBody @Valid TeamDto teamDto){
        return ResponseEntity.ok(teamService.updateTeam(id, teamDto));
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable long id){
        teamService.deleteTeam(id);
    }
}

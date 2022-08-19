package com.fatihk.examples.springboot.postgresqlexample.controller;

import com.fatihk.examples.springboot.postgresqlexample.dto.PlayerDto;
import com.fatihk.examples.springboot.postgresqlexample.service.IPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final IPlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto PlayerDto){
        return new ResponseEntity<>(playerService.createPlayer(PlayerDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayers(){
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayer(@PathVariable long id){
        return ResponseEntity.ok(playerService.getPlayer(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable("id") int id, @RequestBody PlayerDto playerDto){
        return ResponseEntity.ok(playerService.updatePlayer(id, playerDto));
    }
}

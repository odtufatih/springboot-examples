package com.fatihk.examples.springboot.postgresqlexample.service.impl;

import com.fatihk.examples.springboot.postgresqlexample.dto.PlayerDto;
import com.fatihk.examples.springboot.postgresqlexample.exception.ResourceNotFoundException;
import com.fatihk.examples.springboot.postgresqlexample.model.Player;
import com.fatihk.examples.springboot.postgresqlexample.model.Team;
import com.fatihk.examples.springboot.postgresqlexample.repository.PlayerRepository;
import com.fatihk.examples.springboot.postgresqlexample.service.IPlayerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService implements IPlayerService {

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;

    @Override
    public PlayerDto createPlayer(PlayerDto playerDto) {
        Player player = modelMapper.map(playerDto, Player.class);
        player.setUpdatedDate(LocalDateTime.now());
        player = playerRepository.save(player);
        playerDto.setId(player.getId());
        return playerDto;
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        List<PlayerDto> playerDtos = new ArrayList<>();
        players.forEach( player -> {
            playerDtos.add(modelMapper.map(player, PlayerDto.class));
        });
        return playerDtos;
    }

    @Override
    public PlayerDto getPlayer(long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No player with id:" + id));
        return modelMapper.map(player, PlayerDto.class);
    }

    @Override
    public List<PlayerDto> getPlayersByTeamId(long id) {
        List<Player> players = playerRepository.findByTeamId(id);
        List<PlayerDto> playerDtos = new ArrayList<>();
        players.forEach( player -> {
            playerDtos.add(modelMapper.map(player, PlayerDto.class));
        });
        return playerDtos;
    }

    @Override
    public PlayerDto updatePlayer(long id, PlayerDto playerDto) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No player with id:" + id));
        playerDto.setId(id);
        modelMapper.map(playerDto, player);
        playerRepository.save(player);
        return playerDto;
    }


}

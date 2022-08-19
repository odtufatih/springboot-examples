package com.fatihk.examples.springboot.postgresqlexample.service;

import com.fatihk.examples.springboot.postgresqlexample.dto.PlayerDto;

import java.util.List;

public interface IPlayerService {

    public PlayerDto createPlayer(PlayerDto playerDto);

    public List<PlayerDto> getAllPlayers();

    public PlayerDto updatePlayer(long id, PlayerDto playerDto);

    public PlayerDto getPlayer(long id);

    public List<PlayerDto> getPlayersByTeamId(long teamId);
}

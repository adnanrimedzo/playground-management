package com.some.playgraund.service;

import com.some.playgraund.model.Player;
import com.some.playgraund.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(long playerId) {
        playerRepository.deleteById(playerId);
    }

    @Override
    public List<Player> listPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayer(long playerId) {
        return playerRepository.findById(playerId).get();
    }

    @Override
    public List<Player> getPlayerHistoryByName(String name) {
        return playerRepository.findAllByName(name);
    }
}

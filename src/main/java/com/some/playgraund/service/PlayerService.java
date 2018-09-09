package com.some.playgraund.service;

import com.some.playgraund.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlayerService {

    Player addPlayer(Player player);
    Player updatePlayer(Player player);
    void deletePlayer(long playerId);
    List<Player> listPlayer();
    Player getPlayer(long playerId);
    List<Player> getPlayerHistoryByName(String name);
}

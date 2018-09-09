package com.some.playgraund.repository;

import com.some.playgraund.model.Player;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, Long> {
    List<Player> findAllByName(String name);
}

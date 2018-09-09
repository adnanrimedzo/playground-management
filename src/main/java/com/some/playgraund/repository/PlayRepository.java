package com.some.playgraund.repository;

import com.some.playgraund.model.Play;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface PlayRepository extends MongoRepository<Play, Long> {
    List<Play> findAllByPlayTime(Date playTime);
    Long countAllByPlayerSiteIdAndPlayTime(Long playSiteId, Date playTime);
}

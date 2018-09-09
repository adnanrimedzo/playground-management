package com.some.playgraund.repository;

import com.some.playgraund.model.SnapShot;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SnapShotRepository extends MongoRepository<SnapShot, Long> {
    List<SnapShot> findAllBySnapShotTime(Date date);
}

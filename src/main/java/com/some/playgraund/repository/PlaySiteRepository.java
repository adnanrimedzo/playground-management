package com.some.playgraund.repository;

import com.some.playgraund.model.PlaySite;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaySiteRepository extends MongoRepository<PlaySite, Long> {
    List<PlaySite> findByName(String name);
}
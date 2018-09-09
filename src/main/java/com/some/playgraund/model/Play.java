package com.some.playgraund.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
public class Play {

    @Id
    long id;
    long playerId;
    long playerSiteId;
    Date playTime;

    public Play(long playerId, long playerSiteId, Date playTime){
        this.playerId = playerId;
        this.playerSiteId = playerSiteId;
        this.playTime = playTime;
    }

}

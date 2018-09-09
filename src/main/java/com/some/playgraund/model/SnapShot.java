package com.some.playgraund.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document
public class SnapShot {

    @Id
    long id;
    List<PlaySite> playSiteList;
    Date snapShotTime;

    public SnapShot(List<PlaySite> playSiteList, Date snapShotTime) {
        this.playSiteList = playSiteList;
        this.snapShotTime = snapShotTime;
    }
}

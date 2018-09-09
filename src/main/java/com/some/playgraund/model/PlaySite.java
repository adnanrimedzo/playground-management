package com.some.playgraund.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.LinkedList;
import java.util.Queue;

@Getter
@Setter
@Document
public class PlaySite {

    @Id
    long id;
    String name;
    int playerCapacity;
    int queCapacity;
    Queue<Long> waitingQue = new LinkedList<>();

    public int getQueSize() {
        return waitingQue.size();
    }

}

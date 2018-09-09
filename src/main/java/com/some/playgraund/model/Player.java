package com.some.playgraund.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Getter
@Setter
@Document
public class Player {

    @Id
    long id;
    String name;
    int age;
    String ticketPlaySiteName;
}

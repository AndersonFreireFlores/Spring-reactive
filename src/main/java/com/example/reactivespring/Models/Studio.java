package com.example.reactivespring.Models;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;

import java.util.Date;

@Document
public class Studio {

    @Id
    private String id;

    @NonNull
    private String name;

    private String country;

    private Date founded;

    private Flux<Game> games;

    public Studio() {
    }

    public Studio(String id, String name, String country, Date founded, Flux<Game> games) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.founded = founded;
        this.games = games;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    public Flux<Game> getGames() {
        return games;
    }

    public void setGames(Flux<Game> games) {
        this.games = games;
    }
}

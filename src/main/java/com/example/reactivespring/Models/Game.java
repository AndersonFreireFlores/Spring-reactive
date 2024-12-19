package com.example.reactivespring.Models;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Game {

    @Id
    private String id;

    @NonNull
    private String name;

    private String genre;

    @NonNull
    private List<String> platform;

    @NonNull
    private Studio studio;

    public Game() {
    }

    public Game(String id, String name, String genre, List<String> platform, Studio studio) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.studio = studio;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getPlatform() {
        return platform;
    }

    public void setPlatform(List<String> platform) {
        this.platform = platform;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}

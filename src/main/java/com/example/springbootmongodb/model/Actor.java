package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "actor")
public class Actor
{

    @Id
    public String actorId;
    public String firstName;
    public String lastName;
    public LocalDate lastUpdate;
    public List<Film> films;

    public Actor() {
    }

    public Actor(String actorId, String firstName, String lastName, LocalDate lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
        this.films = new ArrayList<>();
    }

    public void addFilm(Film film)
    {
        this.films.add(film);
    }
}

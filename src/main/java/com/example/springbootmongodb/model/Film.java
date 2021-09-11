package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "film")
public class Film
{
    @Id
    public String filmId;
    public String title;
    public String description;
    public String releaseYear;
    public String rentalDuration;
    public String rentalRate;
    public String length;
    public String replacementCost;
    public String rating;
    public LocalDate lastUpdate;
    public String specialFeatures;
    public String fullText;
    public Language language;
    public List<Category> categories;
    public List<Actor> actors;
    public List<Inventory> inventories;

    public Film(String  filmId, String title, String description, String releaseYear, String rentalDuration,
                String rentalRate, String length, String replacementCost, String rating, LocalDate lastUpdate,
                String specialFeatures, String fullText,Language language, List<Category> categories) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.lastUpdate = lastUpdate;
        this.specialFeatures = specialFeatures;
        this.fullText = fullText;
        this.language = language;
        this.categories = categories;
        this.actors = new ArrayList<>();
        this.inventories = new ArrayList<>();
    }

    public Film(String  filmId, String title, String description, String releaseYear, String rentalDuration,
                String rentalRate, String length, String replacementCost, String rating, LocalDate lastUpdate,
                String specialFeatures, String fullText) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.lastUpdate = lastUpdate;
        this.specialFeatures = specialFeatures;
        this.fullText = fullText;
        this.categories = new ArrayList<>();
        this.actors = new ArrayList<>();
        this.inventories = new ArrayList<>();
    }

    public Film(){}

    public void addCategory(Category category)
    {
        this.categories.add(category);
    }

    public void addActor(Actor actor)
    {
        this.actors.add(actor);
    }

    public void addInventory(Inventory inventory)
    {
        this.inventories.add(inventory);
    }

}

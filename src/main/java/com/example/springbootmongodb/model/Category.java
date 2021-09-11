package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "category")
public class Category
{
    @Id
    public String categoryId;
    public String name;
    public LocalDate lastUpdate;

    public Category(String categoryId, String name, LocalDate lastUpdate) {
        this.categoryId = categoryId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Category() {
    }
}

package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "language")
public class Language
{
    @Id
    public String languageId;
    public String name;
    public LocalDate lastUpdate;

    public Language(String languageId, String name, LocalDate lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Language() {
    }
}

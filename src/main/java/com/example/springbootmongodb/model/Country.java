package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "country")
public class Country
{
    @Id
    public String countryId;
    public String country;
    public LocalDate lastUpdate;

    public Country() {
    }

    public Country(String countryId, String country, LocalDate lastUpdate) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }
}

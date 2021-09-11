package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "city")
@Data
public class City
{
    @Id
    public String cityId;
    public String city;
    public Country country;
    public LocalDate lastUpdate;

    public City(String cityId, String city, LocalDate lastUpdate) {
        this.cityId = cityId;
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public City() {
    }
}

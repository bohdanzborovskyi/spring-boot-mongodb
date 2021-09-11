package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "inventory")
public class Inventory
{
    @Id
    public String inventoryId;
    public Film film;
    public Store store;
    public LocalDate lastUpdate;

    public Inventory(String inventoryId, LocalDate lastUpdate) {
        this.inventoryId = inventoryId;
        this.lastUpdate = lastUpdate;
    }

    public Inventory() {
    }
}

package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "rental")
public class Rental
{
    @Id
    public String rentalId;
    public LocalDate rentalDate;
    public Customer customer;
    public LocalDate returnDate;
    public Staff staff;
    public LocalDate lastUpdate;
    public Inventory inventory;

    public Rental(String rentalId, LocalDate rentalDate, LocalDate returnDate, LocalDate lastUpdate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.lastUpdate = lastUpdate;
    }

    public Rental() {
    }
}

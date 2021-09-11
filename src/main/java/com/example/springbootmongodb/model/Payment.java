package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "payment")
public class Payment
{
    @Id
    public String paymentId;
    public Customer customer;
    public Staff staff;
    public Rental Rental;
    public double amount;
    public LocalDate lastUpdate;

    public Payment(String paymentId, double amount, LocalDate lastUpdate) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.lastUpdate = lastUpdate;
    }

    public Payment() {
    }
}

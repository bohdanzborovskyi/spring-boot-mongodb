package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "customer")
public class Customer
{
    @Id
    public String customerId;
    public Store store;
    public String firstName;
    public String lastName;
    public String email;
    public Address address;
    public boolean active;
    public LocalDate createDate;
    public List<Rental> rentals;
    public List<Payment>payments;

    public Customer(String customerId, String firstName, String lastName, String email, boolean active) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.createDate = LocalDate.now();
        this.rentals = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public Customer() {
    }

    public void addRental(Rental rental)
    {
        this.rentals.add(rental);
    }

    public void addPayment(Payment payment)
    {
        this.payments.add(payment);
    }
}

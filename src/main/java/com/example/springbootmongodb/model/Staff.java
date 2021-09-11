package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.stream.events.StartDocument;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "staff")
public class Staff
{
    @Id
    public String staffId;
    public String firstName;
    public String lastName;
    public Address address;
    public String email;
    public Store store;
    public boolean active;
    public String userName;
    public String password;
    public LocalDate lastUpdate;
    public File picture;
    public List<Payment> payments;
    public List<Rental> rentals;

    public Staff(String staffId, String firstName, String lastName, String email,
                 boolean active, String userName, String password, LocalDate lastUpdate) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.userName = userName;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.payments = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public Staff(){}

    public void addPayment(Payment payment)
    {
        this.payments.add(payment);
    }

    public void addRental(Rental rental)
    {
        this.rentals.add(rental);
    }
}

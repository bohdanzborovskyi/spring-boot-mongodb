package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "address")
public class Address
{
    @Id
    public String addressId;
    public String address;
    public String address2;
    public String district;
    public City city;
    public String postalCode;
    public String phone;
    public LocalDate lastUpdate;

    public Address(String addressId, String address, String address2,
                   String district, String postalCode, String phone, LocalDate lastUpdate) {
        this.addressId = addressId;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
        this.lastUpdate = lastUpdate;
    }

    public Address() {
    }
}

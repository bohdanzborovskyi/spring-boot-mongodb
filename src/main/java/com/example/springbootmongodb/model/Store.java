package com.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "store")
public class Store
{
    @Id
    public String storeId;
    public List<Staff> staff;
    public Address address;
    public List<Inventory> inventories;
    public LocalDate lastUpdate;
    public List<Customer> customers;

    public Store(String storeId, LocalDate lastUpdate) {
        this.storeId = storeId;
        this.lastUpdate = lastUpdate;
        this.inventories = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    public Store() {
    }

    public void addInventory(Inventory inventory)
    {
        this.inventories.add(inventory);
    }

    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
    }

    public void addStaff(Staff staff)
    {
        this.staff.add(staff);
    }
}

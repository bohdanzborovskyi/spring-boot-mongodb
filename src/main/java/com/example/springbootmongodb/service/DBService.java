package com.example.springbootmongodb.service;

import com.example.springbootmongodb.model.*;
import com.example.springbootmongodb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DBService
{

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StoreRepository storeRepository;

    public List<Category> getAllFilmCategorySortByName()
    {
        return categoryRepository.findAll().stream().sorted(Comparator.comparing(Category::getName)).collect(Collectors.toList());
    }

    public List<Film> getAllFilmByCategory(Integer pageNumber, String category)
    {
        List<Film> filmsByCategory = filmRepository.findAll().stream().filter(film -> film.getCategories().contains(categoryRepository.findByName(category))).collect(Collectors.toList());
        if(filmsByCategory.size()>(pageNumber+1)*20)
            return filmsByCategory.subList(pageNumber*20,(pageNumber+1)*20);
        else
            return filmsByCategory;
    }

    public List<Film> getAllFilmByLanguage(String language)
    {
        return filmRepository.findAll().stream().filter(film -> film.getLanguage().getName().equals(language)).collect(Collectors.toList());
    }

    public List<Actor>  getAllActorByFilmTitle(String title)
    {
        return filmRepository.findByTitle(title).getActors();
    }

    public String getFilmStatus(String title)
    {
        List<String> inventories =  filmRepository.findByTitle(title).getInventories().stream().map(Inventory::getInventoryId).collect(Collectors.toList());
        List<Rental> rentalsByInventoryId = rentalRepository.findAll().stream().filter(rental -> inventories.contains(rental.getInventory().getInventoryId())).collect(Collectors.toList());
        if(rentalsByInventoryId.stream().filter(rental -> rental.returnDate.isAfter(LocalDate.now())).collect(Collectors.toList()).size()>0)
            return "Not available";
        else
            return "Available";
    }

    public List<Payment> getAllPaymentByCustomer(String id)
    {
        return customerRepository.findById(id).get().getPayments();
    }

    public String getCustomerInfoAndAddress(String id)
    {
        Customer customer = customerRepository.findById(id).get();
        String info = "Cutomer: " + customer.firstName + " " + customer.lastName + ", email: " + customer.getEmail();
        String address = "Address: " + customer.getAddress().getAddress() + " " + customer.getAddress().getAddress2() +
                ", postal code: " + customer.getAddress().getPostalCode() +
                ", district: " + customer.getAddress().getDistrict() +
                ", city: " + customer.getAddress().getCity().getCity() +
                ", country: " + customer.getAddress().getCity().getCountry().getCountry() +
                ", phone: " +  customer.getAddress().getPhone();
        return info + " \n" + address;
    }

    public List<Staff> getAllStaffByStore(String id)
    {
        return storeRepository.findById(id).get().getStaff();
    }

    public List<Film> getAllFilmByActor(String firstName, String lastName)
    {
       return actorRepository.findAll().stream().filter(actor1 -> actor1.lastName.equals(lastName) && actor1.firstName.equals(firstName)).findAny().get().getFilms();
    }

    public List<Rental> getAllRentalByCustomer(String id, Integer pageNumber)
    {
        List<Rental> rentals = customerRepository.findById(id).get().getRentals().stream().sorted(Comparator.comparing(Rental::getRentalDate)).collect(Collectors.toList());
        if(rentals.size()>(pageNumber+1)*20)
            return rentals.subList(pageNumber*20, (pageNumber+1)*20);
        else
            return rentals;
    }

}

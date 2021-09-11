package com.example.springbootmongodb;

import com.example.springbootmongodb.model.*;
import com.example.springbootmongodb.repository.*;
import com.example.springbootmongodb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class MongoDBApplication implements CommandLineRunner
{

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    DBService dbService;

    @Override
    public void run(String... args) throws Exception
    {
        //Add languages
        languageRepository.save(new Language("1","Spanish",LocalDate.now()));
        languageRepository.save(new Language("2","English",LocalDate.now()));

        //Add categories
        categoryRepository.save(new Category("2","Drama",LocalDate.now()));
        categoryRepository.save(new Category("1","Horror", LocalDate.now()));
        categoryRepository.save(new Category("3","Adventure", LocalDate.now()));

        //Add actors
        actorRepository.save(new Actor("1","Jude","Allcos",LocalDate.now()));
        actorRepository.save(new Actor("2","Kane","Rubi",LocalDate.now()));
        actorRepository.save(new Actor("3","Kamor","Fuente",LocalDate.now()));
        actorRepository.save(new Actor("4","Luke","Jaazc",LocalDate.now()));


        //Add films
        filmRepository.save(new Film("1","New movie","description","1994","2 weeks",
                "2.5","1h34m","13.6","8.3",
                LocalDate.now(),"special","full text",new Language("1","Spanish",LocalDate.now()),
                List.of(new Category("1","Horror", LocalDate.now()))));
        Film f = filmRepository.findById("1").get();
        f.addCategory(categoryRepository.findById("2").get());
        f.addCategory(categoryRepository.findById("3").get());
        f.addActor(actorRepository.findById("1").get());
        f.addActor(actorRepository.findById("2").get());

        filmRepository.save(f);
        filmRepository.save(new Film("2","Next movie","D description","2001","1 weeks",
                "3.6","2h34m","25","7.3",
                LocalDate.now(),"special","full text"));
        Film film = filmRepository.findById("2").get();
        film.addCategory(categoryRepository.findById("3").get());
        film.addCategory(categoryRepository.findById("2").get());
        film.setLanguage(languageRepository.findById("2").get());
        film.addActor(actorRepository.findById("3").get());
        film.addActor(actorRepository.findById("4").get());
        filmRepository.save(film);

        //Add films to actor
        Actor a = actorRepository.findById("1").get();
        a.addFilm(filmRepository.findById("1").get());
        actorRepository.save(a);
        a = actorRepository.findById("2").get();
        a.addFilm(filmRepository.findById("1").get());
        actorRepository.save(a);
        a = actorRepository.findById("3").get();
        a.addFilm(filmRepository.findById("2").get());
        actorRepository.save(a);
        a = actorRepository.findById("4").get();
        a.addFilm(filmRepository.findById("2").get());
        actorRepository.save(a);

        //Add countries
        countryRepository.save(new Country("1","USA",LocalDate.now()));
        countryRepository.save(new Country("2","Algeria",LocalDate.now()));
        countryRepository.save(new Country("3","China",LocalDate.now()));

        //Add cities
        City c = new City("1","Orlando",LocalDate.now());
        c.setCountry(countryRepository.findById("1").get());
        cityRepository.save(c);
        c = new City("2","Baregh",LocalDate.now());
        c.setCountry(countryRepository.findById("2").get());
        cityRepository.save(c);
        c = new City("3","Beijing",LocalDate.now());
        c.setCountry(countryRepository.findById("3").get());
        cityRepository.save(c);

        //Add addresses
        Address address = new Address("1","Brown st.","3/11","Heane","214-11","800-909-989",LocalDate.now());
        address.setCity(cityRepository.findById("1").get());
        addressRepository.save(address);
        address = new Address("2","Bafje st.","23","Marut","2144-21","202-21-22-111",LocalDate.now());
        address.setCity(cityRepository.findById("2").get());
        addressRepository.save(address);
        address = new Address("3","Ijinchu st.","122/2","Muanpag","213-221","123-333-23",LocalDate.now());
        address.setCity(cityRepository.findById("3").get());
        addressRepository.save(address);

        //Add staff
        Staff staff = new Staff("1","Steve","Rogers","steveR@mail.com",true,"steveR","steve123",LocalDate.now());
        staff.setAddress(addressRepository.findById("1").get());
        staffRepository.save(staff);
        staff = new Staff("2","Angella","Ouk","angellaO@mail.com",false,"angellaO","angella123",LocalDate.now());
        staff.setAddress(addressRepository.findById("2").get());
        staffRepository.save(staff);
        staff = new Staff("3","Tom","Monster","tomM@mail.com",false,"tomM","tom123",LocalDate.now());
        staff.setAddress(addressRepository.findById("2").get());
        staffRepository.save(staff);

        //Add stores
        Store store = new Store("1",LocalDate.now());
        store.setAddress(addressRepository.findById("1").get());
        store.addStaff(staffRepository.findById("1").get());
        store.addStaff(staffRepository.findById("3").get());
        staff = staffRepository.findById("1").get();
        staff.setStore(store);
        staffRepository.save(staff);
        staff = staffRepository.findById("3").get();
        staff.setStore(store);
        staffRepository.save(staff);
        storeRepository.save(store);
        store = new Store("2",LocalDate.now());
        store.setAddress(addressRepository.findById("2").get());
        store.addStaff(staffRepository.findById("2").get());
        staff = staffRepository.findById("2").get();
        staff.setStore(store);
        staffRepository.save(staff);
        storeRepository.save(store);

        //Add inventories
        Inventory inventory = new Inventory("1",LocalDate.now());
        inventory.setFilm(filmRepository.findById("1").get());
        inventory.setStore(storeRepository.findById("1").get());
        inventoryRepository.save(inventory);
        film = filmRepository.findById("1").get();
        film.addInventory(inventory);
        filmRepository.save(film);
        store = storeRepository.findById("1").get();
        store.addInventory(inventory);
        storeRepository.save(store);
        inventory = new Inventory("2",LocalDate.now());
        inventory.setFilm(filmRepository.findById("2").get());
        inventory.setStore(storeRepository.findById("2").get());
        inventoryRepository.save(inventory);
        film = filmRepository.findById("2").get();
        film.addInventory(inventory);
        filmRepository.save(film);
        store = storeRepository.findById("1").get();
        store.addInventory(inventory);
        storeRepository.save(store);
        inventory = new Inventory("3",LocalDate.now());
        inventory.setFilm(filmRepository.findById("2").get());
        inventory.setStore(storeRepository.findById("2").get());
        inventoryRepository.save(inventory);
        film = filmRepository.findById("2").get();
        film.addInventory(inventory);
        filmRepository.save(film);
        store = storeRepository.findById("2").get();
        store.addInventory(inventory);
        storeRepository.save(store);

        //Add customers
        Customer customer = new Customer("1","Steve","Looper","looper@mail.com",true);
        customer.setAddress(addressRepository.findById("1").get());
        customerRepository.save(customer);
        customer = new Customer("2","Inn","Active","active@mail.com",true);
        customer.setAddress(addressRepository.findById("2").get());
        customerRepository.save(customer);

        //Add customers to store
        store = storeRepository.findById("1").get();
        store.addCustomer(customerRepository.findById("1").get());
        storeRepository.save(store);
        store = storeRepository.findById("2").get();
        store.addCustomer(customerRepository.findById("2").get());
        storeRepository.save(store);

        //Add rentals
        Rental rental = new Rental("1",LocalDate.now(),LocalDate.now().plusDays(9),LocalDate.now());
        rental.setStaff(staffRepository.findById("1").get());
        rental.setCustomer(customerRepository.findById("1").get());
        rental.setInventory(inventoryRepository.findById("1").get());
        customer = customerRepository.findById("1").get();
        customer.addRental(rental);
        customerRepository.save(customer);
        staff = staffRepository.findById("1").get();
        staff.addRental(rental);
        staffRepository.save(staff);
        rentalRepository.save(rental);
        rental = new Rental("2",LocalDate.now().minusDays(10),LocalDate.now().minusDays(4),LocalDate.now());
        rental.setStaff(staffRepository.findById("2").get());
        rental.setCustomer(customerRepository.findById("2").get());
        rental.setInventory(inventoryRepository.findById("2").get());
        customer = customerRepository.findById("2").get();
        customer.addRental(rental);
        customerRepository.save(customer);
        staff = staffRepository.findById("2").get();
        staff.addRental(rental);
        staffRepository.save(staff);
        rentalRepository.save(rental);

        //Add payments
        Payment payment = new Payment("1",12.5,LocalDate.now());
        payment.setCustomer(customerRepository.findById("1").get());
        payment.setStaff(staffRepository.findById("1").get());
        payment.setRental(rentalRepository.findById("1").get());
        customer = customerRepository.findById("1").get();
        customer.addPayment(payment);
        customerRepository.save(customer);
        staff = staffRepository.findById("1").get();
        staff.addPayment(payment);
        staffRepository.save(staff);
        paymentRepository.save(payment);
        payment = new Payment("2",12.5,LocalDate.now());
        payment.setCustomer(customerRepository.findById("2").get());
        payment.setStaff(staffRepository.findById("2").get());
        payment.setRental(rentalRepository.findById("2").get());
        customer = customerRepository.findById("2").get();
        customer.addPayment(payment);
        customerRepository.save(customer);
        staff = staffRepository.findById("2").get();
        staff.addPayment(payment);
        staffRepository.save(staff);
        paymentRepository.save(payment);

        //DB methods
//        dbService.getAllFilmCategorySortByName().forEach(category -> System.out.println(category.name));
//        dbService.getAllFilmByCategory(0,"Horror").forEach(film1 -> System.out.println(film1.getTitle()));
//        System.out.println(dbService.getAllFilmByLanguage("English"));
        System.out.println(dbService.getAllActorByFilmTitle("Next movie"));
//        System.out.println(dbService.getAllPaymentByCustomer("1"));
//        System.out.println(dbService.getCustomerInfoAndAddress("1"));
//        System.out.println(dbService.getAllStaffByStore("2"));
//        dbService.getAllStaffByStore("1").forEach(staff1 -> System.out.println(staff1.getFirstName() + " " + staff1.getLastName()));
//        System.out.println(dbService.getAllFilmByActor("Kamor","Fuente"));
//        dbService.getAllRentalByCustomer("1",0).
//                forEach(rental1 -> System.out.println(rental1.getCustomer().getCustomerId() + " " + rental1.getRentalDate() +
//                        " " + rental1.getReturnDate()));
    }
}

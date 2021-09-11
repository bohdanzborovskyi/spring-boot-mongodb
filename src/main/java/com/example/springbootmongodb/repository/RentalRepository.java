package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends MongoRepository<Rental,String>
{

}

package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<City,String>
{

}

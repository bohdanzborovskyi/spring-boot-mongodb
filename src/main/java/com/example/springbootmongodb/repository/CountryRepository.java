package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends MongoRepository<Country,String>
{

}

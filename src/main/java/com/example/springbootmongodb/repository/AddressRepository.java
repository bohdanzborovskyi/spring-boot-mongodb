package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address,String>
{

}

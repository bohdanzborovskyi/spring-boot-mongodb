package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends MongoRepository<Store,String>
{

}

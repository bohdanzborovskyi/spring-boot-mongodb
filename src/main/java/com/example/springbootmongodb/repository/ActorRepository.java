package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends MongoRepository<Actor,String>
{

}

package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Language;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends MongoRepository<Language,String>
{

}

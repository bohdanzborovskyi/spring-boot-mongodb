package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends MongoRepository<Film,String>
{
    Film findByTitle(String title);
}

package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String>
{
    Category findByName(String name);
}

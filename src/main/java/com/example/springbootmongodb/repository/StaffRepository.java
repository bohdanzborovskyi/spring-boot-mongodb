package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends MongoRepository<Staff,String>
{

}

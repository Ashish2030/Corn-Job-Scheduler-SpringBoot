package com.example.demo.repository;

import com.example.demo.model.database;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface database123 extends MongoRepository<database, Integer> {
    Optional<database> findByDate(String date);

}

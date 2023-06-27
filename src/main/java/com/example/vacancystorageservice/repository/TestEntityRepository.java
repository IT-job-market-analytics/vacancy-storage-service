package com.example.vacancystorageservice.repository;

import com.example.vacancystorageservice.model.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestEntityRepository extends MongoRepository<TestEntity, String> {
}

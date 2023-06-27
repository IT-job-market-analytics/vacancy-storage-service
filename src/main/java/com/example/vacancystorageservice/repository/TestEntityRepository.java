package com.example.vacancystorageservice.repository;

import com.example.vacancystorageservice.model.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityRepository extends MongoRepository<TestEntity, String> {
}

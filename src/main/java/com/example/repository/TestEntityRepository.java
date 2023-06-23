package com.example.repository;

import com.example.model.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestEntityRepository extends MongoRepository<TestEntity, Long> {

}

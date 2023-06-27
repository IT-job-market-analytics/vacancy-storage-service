package com.example.vacancystorageservice.service;

import com.example.vacancystorageservice.model.TestEntity;
import com.example.vacancystorageservice.repository.TestEntityRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestEntityService {

    private final MongoTemplate mongoTemplate;

    public TestEntityService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<TestEntity> getSelectedTestEntity(String text) {
        Query query = new Query();
        query.addCriteria(Criteria.where("text").is(text));
        List<TestEntity> testEntities = mongoTemplate.find(query, TestEntity.class);

        if (testEntities.isEmpty()) {
            System.out.println("no one records in mongoDB with text: " + text);
        }

        return testEntities;
    }
}

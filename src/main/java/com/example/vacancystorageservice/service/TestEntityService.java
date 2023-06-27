package com.example.vacancystorageservice.service;

import com.example.vacancystorageservice.model.TestEntity;
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

    public List<TestEntity> getSelected(String text) {
        Query query = new Query();
        query.addCriteria(Criteria.where("text").is(text));

        return mongoTemplate.find(query, TestEntity.class);
    }

    public TestEntity save(String text, Integer number){
        TestEntity testEntity = new TestEntity(text, number);
        mongoTemplate.save(testEntity);
        return testEntity;
    }
}

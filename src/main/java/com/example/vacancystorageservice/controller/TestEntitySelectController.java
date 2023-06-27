package com.example.vacancystorageservice.controller;

import com.example.vacancystorageservice.model.TestEntity;
import com.example.vacancystorageservice.service.TestEntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestEntitySelectController {

    private TestEntityService testEntityService;

    public TestEntitySelectController(TestEntityService testEntityService) {
        this.testEntityService = testEntityService;
    }

    @GetMapping("/test/select")
    public List<TestEntity> test(@RequestParam String text){
        List<TestEntity> testEntityList = testEntityService.getSelectedTestEntity(text);
        return testEntityList;
    }

}

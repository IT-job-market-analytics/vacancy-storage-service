package com.example.vacancystorageservice.controller;

import com.example.vacancystorageservice.model.TestEntity;
import com.example.vacancystorageservice.service.TestEntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEntitySaveController {

    private final TestEntityService testEntityService;

    public TestEntitySaveController(TestEntityService testEntityService) {
        this.testEntityService = testEntityService;
    }

    @GetMapping("/test/save")
    public TestEntity save(@RequestParam String text, @RequestParam Integer number){
        return testEntityService.save(text, number);
    }
}

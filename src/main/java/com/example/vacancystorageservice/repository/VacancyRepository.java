package com.example.vacancystorageservice.repository;

import com.example.vacancystorageservice.model.Vacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends MongoRepository<Vacancy, String> {
}

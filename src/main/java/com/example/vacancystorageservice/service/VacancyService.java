package com.example.vacancystorageservice.service;

import com.example.vacancystorageservice.converter.VacancyConverter;
import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.model.Vacancy;
import com.example.vacancystorageservice.repository.VacancyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class VacancyService {

    private final static Logger LOGGER = LoggerFactory.getLogger(VacancyConverter.class);

    private final MongoTemplate mongoTemplate;
    private final VacancyConverter vacancyConverter;
    private final VacancyRepository vacancyRepository;

    public VacancyService(MongoTemplate mongoTemplate, VacancyConverter vacancyConverter, VacancyRepository vacancyRepository) {
        this.mongoTemplate = mongoTemplate;
        this.vacancyConverter = vacancyConverter;
        this.vacancyRepository = vacancyRepository;
    }

    @SuppressWarnings("UnusedReturnValue")
    public Vacancy convertAndSave(VacancyDto vacancyDto) {
        Vacancy vacancyModel = vacancyConverter.fromDtoToModel(vacancyDto);
        vacancyRepository.save(vacancyModel);
        LOGGER.info("Save to MongoDB: " + vacancyModel);
        return vacancyModel;
    }
}

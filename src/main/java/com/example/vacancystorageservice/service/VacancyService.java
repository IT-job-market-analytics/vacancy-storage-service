package com.example.vacancystorageservice.service;

import com.example.vacancystorageservice.converter.VacancyConverter;
import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.model.Vacancy;
import com.example.vacancystorageservice.repository.VacancyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VacancyService {
    private final static Logger LOGGER = LoggerFactory.getLogger(VacancyService.class);

    private final VacancyConverter vacancyConverter;
    private final VacancyRepository vacancyRepository;

    public VacancyService(VacancyConverter vacancyConverter, VacancyRepository vacancyRepository) {
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

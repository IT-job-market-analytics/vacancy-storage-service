package com.example.vacancystorageservice.service;

import com.example.vacancystorageservice.converter.VacancyConverter;
import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.model.Vacancy;
import com.example.vacancystorageservice.repository.VacancyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VacancyService {
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
        log.info("Save to MongoDB: " + vacancyModel);
        return vacancyModel;
    }
}

package com.example.vacancystorageservice.service;

import com.example.vacancystorageservice.converter.VacancyConverter;
import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.model.Vacancy;
import com.example.vacancystorageservice.repository.VacancyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        log.debug("Persisting vacancy #" + vacancyDto.getId());

        Vacancy newVacancy = vacancyConverter.fromDtoToModel(vacancyDto);

        Optional<Vacancy> existingVacancy = vacancyRepository.findById(newVacancy.getId());
        if (existingVacancy.isEmpty()) {
            log.debug("It didn't exist before, so we save it");
            vacancyRepository.save(newVacancy);
        } else {
            log.debug("It already exists, so we append new query \"" + vacancyDto.getQuery() + "\" to it");

            newVacancy.getQueries().addAll(existingVacancy.get().getQueries());
            log.debug("Resulting queries: " + newVacancy.getQueries());

            vacancyRepository.save(newVacancy);
        }

        log.debug("Vacancy #" + vacancyDto.getId() + " persisted");
        return newVacancy;
    }
}

package com.example.vacancystorageservice.service;

import com.example.vacancystorageservice.converter.VacancyConverter;
import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.model.Vacancy;
import com.example.vacancystorageservice.repository.VacancyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class VacancyService {
    private final VacancyConverter vacancyConverter;
    private final VacancyRepository vacancyRepository;

    public VacancyService(VacancyConverter vacancyConverter, VacancyRepository vacancyRepository) {
        this.vacancyConverter = vacancyConverter;
        this.vacancyRepository = vacancyRepository;
    }

    public PersistenceResult convertAndSaveOrUpdate(VacancyDto vacancyDto) {
        log.debug("Persisting vacancy #" + vacancyDto.getId());

        PersistenceResult result;
        Vacancy newVacancy = vacancyConverter.fromDtoToModel(vacancyDto);

        Optional<Vacancy> existingVacancy = vacancyRepository.findById(newVacancy.getId());
        if (existingVacancy.isEmpty()) {
            log.debug("It didn't exist before, so we save it");
            vacancyRepository.save(newVacancy);

            result = PersistenceResult.INSERTED;
        } else {
            Set<String> existingQueries = existingVacancy.get().getQueries();
            log.debug("It already exists with queries: " + existingQueries);

            if (existingQueries.contains(vacancyDto.getQuery())) {
                log.debug("It already exists with this query");
                result = PersistenceResult.UPDATED_WITH_EXISTING_QUERY;
            } else {
                log.debug("Appending new query \"" + vacancyDto.getQuery() + "\" to it");
                log.debug("Resulting queries: " + newVacancy.getQueries());

                result = PersistenceResult.UPDATED_AND_NEW_QUERY_ADDED;
            }

            newVacancy.getQueries().addAll(existingQueries);
            log.debug("Resulting queries: " + newVacancy.getQueries());

            vacancyRepository.save(newVacancy);
        }

        log.debug("Vacancy #" + vacancyDto.getId() + " persisted, result = " + result);
        return result;
    }
}

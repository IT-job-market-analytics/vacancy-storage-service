package com.example.vacancystorageservice.service;

import com.example.vacancystorageservice.converter.VacancyConverter;
import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.model.Vacancy;
import com.example.vacancystorageservice.repository.VacancyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VacancyServiceTest {

    @Mock
    private VacancyRepository repository;
    private final VacancyConverter vacancyConverter = new VacancyConverter(new ModelMapper());

    @Test
    void convertAndSaveOrUpdate_3_scenario() {
        vacancyConverter.initMapping();

        VacancyDto vacancyDto = new VacancyDto();
        vacancyDto.setId("123");
        vacancyDto.setName("Разработчик");
        vacancyDto.setQuery("Java");
        vacancyDto.setPublishedAt("2023-08-11T04:36:41+0300");

        VacancyService service = new VacancyService(vacancyConverter, repository);

        // add a new one Vacancy
        PersistenceResult result = service.convertAndSaveOrUpdate(vacancyDto);
        assertThat(result).isEqualTo(PersistenceResult.INSERTED);

        Vacancy vacancy = new Vacancy();
        vacancy.setId("123");
        vacancy.setQueries(Set.of("Java"));
        when(repository.findById("123")).thenReturn(Optional.of(vacancy));

        // try add existed vacancy with updated field instead query
        result = service.convertAndSaveOrUpdate(vacancyDto);
        assertThat(result).isEqualTo(PersistenceResult.UPDATED_WITH_EXISTING_QUERY);

        vacancyDto.setQuery("Kotlin");

        // try add updated vacancy with new query
        result = service.convertAndSaveOrUpdate(vacancyDto);
        assertThat(result).isEqualTo(PersistenceResult.UPDATED_AND_NEW_QUERY_ADDED);
    }
}
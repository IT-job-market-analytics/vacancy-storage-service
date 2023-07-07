package com.example.vacancystorageservice.converter;

import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.model.Vacancy;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class VacancyConverter {
    ModelMapper modelMapper;

    public VacancyConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void initMapping() {
        TypeMap<VacancyDto, Vacancy> typeMap = modelMapper.getTypeMap(VacancyDto.class, Vacancy.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(VacancyDto.class, Vacancy.class);
        }

        // convert string to LocalDateTime
        Converter<String, LocalDateTime> toLocalDateTime = new AbstractConverter<>() {
            @Override
            protected LocalDateTime convert(String s) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
                return LocalDateTime.parse(s, formatter);
            }
        };
        typeMap.addMappings(mapper -> mapper.using(toLocalDateTime).map(VacancyDto::getPublishedAt, Vacancy::setPublishedAt));

        // convert string from query to List<String> queries
        Converter<String, Set<String>> toSetFromLonelyString = new AbstractConverter<String, Set<String>>() {
            @Override
            protected Set<String> convert(String s) {
                return new HashSet<>(Collections.singletonList(s));
            }
        };
        typeMap.addMappings(mapper -> mapper.using(toSetFromLonelyString).map(VacancyDto::getQuery, Vacancy::setQueries));

        modelMapper.getConfiguration().setSkipNullEnabled(true);
    }

    public Vacancy fromDtoToModel(VacancyDto vacancyDto) {
        Vacancy vacancyModel = modelMapper.map(vacancyDto, Vacancy.class);
        log.debug("DTO converted to model: " + vacancyModel);
        return vacancyModel;
    }
}

package com.example.vacancystorageservice.converter;

import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.model.Vacancy;
import org.modelmapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class VacancyConverter {
    private final static Logger LOGGER = LoggerFactory.getLogger(VacancyConverter.class);

    ModelMapper modelMapper;

    public VacancyConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Vacancy fromDtoToModel(VacancyDto vacancyDto){
        TypeMap<VacancyDto, Vacancy> typeMap = modelMapper.createTypeMap(VacancyDto.class, Vacancy.class);

        // map id fields
        typeMap.addMapping(VacancyDto::getId, Vacancy::setHhId);

        // convert string to LocalDateTime
        Converter<String, LocalDateTime> toLocalDateTime = new AbstractConverter<>() {
            @Override
            protected LocalDateTime convert(String s) {
                return LocalDateTime.parse(s, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            }
        };
        typeMap.addMappings(mapper -> mapper.using(toLocalDateTime).map(VacancyDto::getPublishedAt, Vacancy::setPublishedAt));

        modelMapper.getConfiguration().setSkipNullEnabled(true);

        Vacancy vacancyModel = modelMapper.map(vacancyDto, Vacancy.class);
        LOGGER.info("Convert VacancyDTO to VacancyModel: " + vacancyModel);
        return vacancyModel;
    }
}

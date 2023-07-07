package com.example.vacancystorageservice.rabbitmq;

import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.service.VacancyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {
    final VacancyService vacancyService;

    public Consumer(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(VacancyDto vacancyDto){
        log.debug("Received message ... -> " + vacancyDto);
        vacancyService.convertAndSave(vacancyDto);

        log.info("Vacancy #" + vacancyDto.getId() + " with query = \"" + vacancyDto.getQuery() + "\" handled");
    }
}

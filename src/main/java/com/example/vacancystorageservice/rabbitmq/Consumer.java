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
    final Producer producer;

    public Consumer(VacancyService vacancyService, Producer producer) {
        this.vacancyService = vacancyService;
        this.producer = producer;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(VacancyDto vacancyDto){
        log.debug("Received message ... -> " + vacancyDto);

        if (vacancyService.convertAndSave(vacancyDto)) {
            producer.send(vacancyDto);
        }

        log.info("Vacancy #" + vacancyDto.getId() + " with query = \"" + vacancyDto.getQuery() + "\" handled");
    }
}

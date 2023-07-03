package com.example.vacancystorageservice.rabbitmq;

import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.service.VacancyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    final VacancyService vacancyService;

    public Consumer(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(VacancyDto vacancyDto){
        LOGGER.info("Received message ... -> " + vacancyDto);
        vacancyService.convertAndSave(vacancyDto);
    }

}

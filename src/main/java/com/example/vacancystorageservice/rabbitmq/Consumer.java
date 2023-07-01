package com.example.vacancystorageservice.rabbitmq;

import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.service.VacancyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    VacancyService vacancyService;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(VacancyDto vacancyDto){
        LOGGER.info("Received message ... -> " + vacancyDto);
        vacancyService.save(vacancyDto);
    }

}

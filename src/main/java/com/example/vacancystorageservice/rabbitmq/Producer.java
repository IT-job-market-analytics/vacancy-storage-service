package com.example.vacancystorageservice.rabbitmq;

import com.example.vacancystorageservice.dto.hh.VacancyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {

    @Value("${rabbitmq.queue.producer.name}")
    private String nameProducerQueue;

    AmqpTemplate amqpTemplate;

        public void send(VacancyDto vacancyDto) {
            amqpTemplate.convertAndSend(nameProducerQueue, vacancyDto);
            log.info("Vacancy #" + vacancyDto.getId() + " with query = \"" + vacancyDto.getQuery() + "\" send to RabbitMQ");
        }
}

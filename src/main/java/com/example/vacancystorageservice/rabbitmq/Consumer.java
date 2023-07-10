package com.example.vacancystorageservice.rabbitmq;

import com.example.vacancystorageservice.dto.hh.VacancyDto;
import com.example.vacancystorageservice.service.PersistenceResult;
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

    @RabbitListener(queues = "${rabbitmq.queue.consumer.name}")
    public void consume(VacancyDto vacancyDto){
        log.trace("Received message ... -> " + vacancyDto);

        PersistenceResult persistenceResult = vacancyService.convertAndSaveOrUpdate(vacancyDto);
        if (persistenceResult == PersistenceResult.INSERTED
                || persistenceResult == PersistenceResult.UPDATED_AND_NEW_QUERY_ADDED
        ) {
            log.debug(
                    "Vacancy #" + vacancyDto.getId() + " with query = \"" + vacancyDto.getQuery() + "\""
                            + " did not exist before (or did not have this query),"
                            + " sending it to " + producer.nameProducerQueue + " queue"
            );

            producer.send(vacancyDto);
        }

        log.info("Vacancy #" + vacancyDto.getId() + " with query = \"" + vacancyDto.getQuery() + "\" handled");
    }
}

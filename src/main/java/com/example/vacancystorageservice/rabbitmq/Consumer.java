package com.example.vacancystorageservice.rabbitmq;

import com.example.vacancystorageservice.dto.hh.Vacancy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(Vacancy vacancy){
        LOGGER.info("Received message ... -> " + vacancy);
    }

}

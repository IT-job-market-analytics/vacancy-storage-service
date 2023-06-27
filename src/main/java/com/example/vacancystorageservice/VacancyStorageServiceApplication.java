package com.example.vacancystorageservice;

import com.example.vacancystorageservice.model.TestEntity;
import com.example.vacancystorageservice.repository.TestEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VacancyStorageServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(VacancyStorageServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TestEntityRepository repository){
        return args -> {
            TestEntity testEntity = new TestEntity("java", 15);

            repository.insert(testEntity);
        };
    }
}

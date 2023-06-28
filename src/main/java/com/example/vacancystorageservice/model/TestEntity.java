package com.example.vacancystorageservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
public class TestEntity {
    @Id
    private String id;
    @Indexed
    String text;
    Integer number;
    @Indexed(expireAfter = "30s")
    LocalDateTime createdAt;

    public TestEntity() {
    }

    public TestEntity(String text, Integer number) {
        this.text = text;
        this.number = number;

        createdAt = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "text='" + text + '\'' +
                ", number=" + number +
                ", createdAt=" + createdAt +
                '}';
    }
}

package com.example.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TestEntity {
    @Indexed
    String text;
    Integer number;
    @Indexed()
    Long createdAt;

    public TestEntity() {
    }

    public TestEntity(String text, Integer number, Long createdAt) {
        this.text = text;
        this.number = number;
        this.createdAt = createdAt;
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

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
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

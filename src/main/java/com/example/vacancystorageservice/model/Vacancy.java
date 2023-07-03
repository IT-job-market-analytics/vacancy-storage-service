package com.example.vacancystorageservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy {
    @Id
    private String Id;
    @Indexed
    private String hhId;
    private String name;
    private String areaName;
    private int salaryFrom;
    private int salaryTo;
    private String typeName;
    private String responseUrl;
    @Indexed(expireAfter = "21d")
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;
    private Boolean archived;
    private String alternateUrl;
    private String employerName;
    private String experienceName;
    private String employmentName;
    @Indexed
    private String query;
}

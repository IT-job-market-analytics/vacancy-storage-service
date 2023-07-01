package com.example.vacancystorageservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
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
    @Indexed(expireAfter = "30s")
    private LocalDateTime publishedAt;
    private LocalDateTime createdAt;
    private Boolean archived;
    private String alternateUrl;
    private String employerName;
    private String experienceName;
    private String employmentName;
    @Indexed
    private String query;

    public String getHhId() {
        return hhId;
    }

    public void setHhId(String hhId) {
        this.hhId = hhId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(int salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public int getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(int salaryTo) {
        this.salaryTo = salaryTo;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getExperienceName() {
        return experienceName;
    }

    public void setExperienceName(String experienceName) {
        this.experienceName = experienceName;
    }

    public String getEmploymentName() {
        return employmentName;
    }

    public void setEmploymentName(String employmentName) {
        this.employmentName = employmentName;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "Id='" + Id + '\'' +
                ", hhId='" + hhId + '\'' +
                ", name='" + name + '\'' +
                ", areaName='" + areaName + '\'' +
                ", salaryFrom=" + salaryFrom +
                ", salaryTo=" + salaryTo +
                ", typeName='" + typeName + '\'' +
                ", responseUrl='" + responseUrl + '\'' +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                ", archived=" + archived +
                ", alternateUrl='" + alternateUrl + '\'' +
                ", employerName='" + employerName + '\'' +
                ", experienceName='" + experienceName + '\'' +
                ", employmentName='" + employmentName + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}

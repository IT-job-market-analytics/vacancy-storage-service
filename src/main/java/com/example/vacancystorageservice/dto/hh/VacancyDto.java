
package com.example.vacancystorageservice.dto.hh;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VacancyDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("areaDto")
    private AreaDto areaDto;
    @JsonProperty("salaryDto")
    private SalaryDto salaryDto;
    @JsonProperty("type")
    private TypeDto typeDto;
    @JsonProperty("response_url")
    private Object responseUrl;
    @JsonProperty("published_at")
    private String publishedAt;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("alternate_url")
    private String alternateUrl;
    @JsonProperty("employer")
    private EmployerDto employer;
    @JsonProperty("snippet")
    private SnippetDto snippet;
    @JsonProperty("experience")
    private ExperienceDto experience;
    @JsonProperty("employment")
    private EmploymentDto employment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
    @JsonProperty("query")
    private String query;
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("areaDto")
    public AreaDto getArea() {
        return areaDto;
    }

    @JsonProperty("areaDto")
    public void setArea(AreaDto areaDto) {
        this.areaDto = areaDto;
    }
    @JsonProperty("salary")
    public SalaryDto getSalaryDto() {
        return salaryDto;
    }

    @JsonProperty("salary")
    public void setSalaryDto(SalaryDto salary) {
        this.salaryDto = salary;
    }

    @JsonProperty("type")
    public TypeDto getType() {
        return typeDto;
    }

    @JsonProperty("type")
    public void setType(TypeDto typeDto) {
        this.typeDto = typeDto;
    }

    @JsonProperty("response_url")
    public Object getResponseUrl() {
        return responseUrl;
    }

    @JsonProperty("response_url")
    public void setResponseUrl(Object responseUrl) {
        this.responseUrl = responseUrl;
    }

    @JsonProperty("published_at")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("published_at")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("archived")
    public Boolean getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @JsonProperty("alternate_url")
    public String getAlternateUrl() {
        return alternateUrl;
    }

    @JsonProperty("alternate_url")
    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    @JsonProperty("employer")
    public EmployerDto getEmployer() {
        return employer;
    }

    @JsonProperty("employer")
    public void setEmployer(EmployerDto employer) {
        this.employer = employer;
    }

    @JsonProperty("snippet")
    public SnippetDto getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(SnippetDto snippet) {
        this.snippet = snippet;
    }

    @JsonProperty("experience")
    public ExperienceDto getExperience() {
        return experience;
    }

    @JsonProperty("experience")
    public void setExperience(ExperienceDto experience) {
        this.experience = experience;
    }

    @JsonProperty("employment")
    public EmploymentDto getEmployment() {
        return employment;
    }

    @JsonProperty("employment")
    public void setEmployment(EmploymentDto employment) {
        this.employment = employment;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "VacancyDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", areaDto=" + areaDto +
                ", salaryDto=" + salaryDto +
                ", typeDto=" + typeDto +
                ", responseUrl=" + responseUrl +
                ", publishedAt='" + publishedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", archived=" + archived +
                ", alternateUrl='" + alternateUrl + '\'' +
                ", employer=" + employer +
                ", snippet=" + snippet +
                ", experience=" + experience +
                ", employment=" + employment +
                ", additionalProperties=" + additionalProperties +
                ", query='" + query + '\'' +
                '}';
    }
}

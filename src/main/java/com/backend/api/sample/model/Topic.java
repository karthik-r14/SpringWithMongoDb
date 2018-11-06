package com.backend.api.sample.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Topic {

    @JsonProperty("id")
    @Id
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    public Topic(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Topic() {
    }
}
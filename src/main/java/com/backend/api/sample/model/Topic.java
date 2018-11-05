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

    public Topic() {
    }

    public Topic(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

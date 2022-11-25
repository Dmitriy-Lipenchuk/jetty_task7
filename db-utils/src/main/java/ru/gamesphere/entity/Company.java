package ru.gamesphere.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Company {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    @JsonCreator
    public Company(@JsonProperty("id") int id,
                   @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}

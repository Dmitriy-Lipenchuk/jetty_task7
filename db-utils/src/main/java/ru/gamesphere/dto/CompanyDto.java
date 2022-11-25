package ru.gamesphere.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CompanyDto {
    @JsonProperty("name")
    private String name;

    @JsonCreator
    public CompanyDto(@JsonProperty("name") String name) {
        this.name = name;
    }
}

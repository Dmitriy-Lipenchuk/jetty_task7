package ru.gamesphere.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Product {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("quantity")
    private int quantity;

    @JsonCreator
    public Product(@JsonProperty("id") int id,
                   @JsonProperty("name") String name,
                   @JsonProperty("company") Company company,
                   @JsonProperty("quantity") int quantity) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.quantity = quantity;
    }
}

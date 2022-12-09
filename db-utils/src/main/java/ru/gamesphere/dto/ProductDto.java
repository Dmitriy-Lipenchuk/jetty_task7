package ru.gamesphere.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("company")
    private CompanyDto company;
    @JsonProperty("quantity")
    private int quantity;

    @JsonCreator
    public ProductDto(@JsonProperty("name") String name,
                      @JsonProperty("company") CompanyDto company,
                      @JsonProperty("quantity") int quantity) {
        this.name = name;
        this.company = company;
        this.quantity = quantity;
    }
}

package com.ecommerce.compositeapi.dto;

public class ProductDto {

    private String id;
    private String name;
    private String description;
    private String category;
    private Double priceUsd;

    public ProductDto() {
    }

    public ProductDto(String id, String name, String description, String category, Double priceUsd) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.priceUsd = priceUsd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(Double priceUsd) {
        this.priceUsd = priceUsd;
    }
}
package com.example.demo.model.binding;

public class SpecialProductBindingModel {

    private String name;
    private Double price;
    private String description;

    public SpecialProductBindingModel() {
    }

    public String getName() {
        return name;
    }

    public SpecialProductBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public SpecialProductBindingModel setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SpecialProductBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}

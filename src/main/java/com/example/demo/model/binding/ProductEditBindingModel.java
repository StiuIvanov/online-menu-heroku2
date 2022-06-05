package com.example.demo.model.binding;

import com.example.demo.model.entity.enums.TypeEnum;

public class ProductEditBindingModel {

    private Long id;
    private String name;
    private Double price;
    private TypeEnum type;

    public Long getId() {
        return id;
    }

    public ProductEditBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductEditBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ProductEditBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductEditBindingModel setPrice(Double price) {
        this.price = price;
        return this;
    }

    public TypeEnum getType() {
        return type;
    }

    public ProductEditBindingModel setType(TypeEnum type) {
        this.type = type;
        return this;
    }
}

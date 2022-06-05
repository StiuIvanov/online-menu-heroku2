package com.example.demo.model.entity;

import com.example.demo.service.impl.CloudinaryImage;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "specials")
public class SpecialProductEntity extends BaseEntity {

    private String name;
    private Double price;
    private String description;
    private PictureEntity picture;


    public SpecialProductEntity() {
    }

    @Column
    public String getName() {
        return name;
    }

    public SpecialProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    public Double getPrice() {
        return price;
    }

    public SpecialProductEntity setPrice(Double price) {
        this.price = price;
        return this;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public SpecialProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @OneToOne
    public PictureEntity getPicture() {
        return picture;
    }

    public SpecialProductEntity setPicture(PictureEntity picture) {
        this.picture = picture;
        return this;
    }
}

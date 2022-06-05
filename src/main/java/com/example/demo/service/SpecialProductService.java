package com.example.demo.service;

import com.example.demo.model.binding.SpecialProductBindingModel;
import com.example.demo.model.entity.SpecialProductEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SpecialProductService {

    void addSpecial(SpecialProductBindingModel specialProductBindingModel, MultipartFile multipartFile);

    SpecialProductEntity getSpecialProductImage();

    void deleteSpecialty();
}

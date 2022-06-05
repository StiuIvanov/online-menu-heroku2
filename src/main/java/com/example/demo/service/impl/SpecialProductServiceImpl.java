package com.example.demo.service.impl;

import com.example.demo.model.binding.SpecialProductBindingModel;
import com.example.demo.model.entity.PictureEntity;
import com.example.demo.model.entity.SpecialProductEntity;
import com.example.demo.repository.SpecialProductRepository;
import com.example.demo.service.CloudinaryService;
import com.example.demo.service.PictureService;
import com.example.demo.service.SpecialProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SpecialProductServiceImpl implements SpecialProductService {


    private final SpecialProductRepository specialProductRepository;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;
    private final PictureService pictureService;

    public SpecialProductServiceImpl(SpecialProductRepository specialProductRepository ,
                                     ModelMapper modelMapper,
                                     CloudinaryService cloudinaryService,
                                     PictureService pictureService) {
        this.specialProductRepository = specialProductRepository;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
        this.pictureService = pictureService;
    }

    @Override
    public void addSpecial(SpecialProductBindingModel bindingModel, MultipartFile file) {
        specialProductRepository.deleteAll();

        PictureEntity picture = null;
        try {
            picture =
                    createPictureEntity(file, bindingModel.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        pictureService.saveToDB(picture);

        SpecialProductEntity specialProductEntity = modelMapper.map(bindingModel, SpecialProductEntity.class);
        specialProductEntity.setPicture(picture);

        specialProductRepository.save(specialProductEntity);
    }

    @Override
    public SpecialProductEntity getSpecialProductImage() {
        List<SpecialProductEntity> all = specialProductRepository.findAll();
        if (all.isEmpty()) {
            return null;
        }

        SpecialProductEntity specialProductEntity = all.get(0);
        return specialProductEntity;
    }

    @Override
    public void deleteSpecialty() {
        specialProductRepository.deleteAll();
    }

    private PictureEntity createPictureEntity(MultipartFile file, String title) throws IOException {
        final CloudinaryImage uploaded = this.cloudinaryService.upload(file);

        return new PictureEntity()
                .setPublicId(uploaded.getPublicId())
                .setTitle(title)
                .setUrl(uploaded.getUrl());
    }

}

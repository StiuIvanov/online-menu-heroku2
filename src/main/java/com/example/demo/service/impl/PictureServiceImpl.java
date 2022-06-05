package com.example.demo.service.impl;

import com.example.demo.model.entity.PictureEntity;
import com.example.demo.repository.PictureRepository;
import com.example.demo.service.PictureService;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public void saveToDB(PictureEntity picture) {
        pictureRepository.save(picture);
    }


}

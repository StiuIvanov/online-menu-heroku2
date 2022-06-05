package com.example.demo.service;

import com.example.demo.model.binding.EventBindingModel;
import com.example.demo.model.entity.EventEntity;

import java.io.IOException;

public interface EventService {

    void addEvent(EventBindingModel eventBindingModel);

    EventEntity getFirstEvent();

    void deleteEvent();

    void cleanEvent();
}

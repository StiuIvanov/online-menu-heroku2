package com.example.demo.service.impl;

import com.example.demo.model.binding.EventBindingModel;
import com.example.demo.model.entity.EventEntity;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ApplicationEventPublisher eventPublisher;

    public EventServiceImpl(EventRepository eventRepository,
                            ApplicationEventPublisher eventPublisher) {
        this.eventRepository = eventRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void addEvent(EventBindingModel eventBindingModel) {
        eventRepository.deleteAll();
        EventEntity eventEntity = new EventEntity();
        eventEntity.setDateTime(LocalDateTime.now());

        boolean eventHasEmbeddedLink = !eventBindingModel.getEmbeddedLink().trim().isEmpty();
        if (eventHasEmbeddedLink) {
            Document parse = Jsoup.parse(eventBindingModel.getEmbeddedLink());
            Elements iframe = parse.select("iframe");
            iframe.attr("width", "100%");
            eventEntity.setEmbeddedLink(iframe.toString());
            eventRepository.save(eventEntity);
            return;
        }

        eventEntity.setLinkImage(eventBindingModel.getLinkImage());
        eventEntity.setLinkEvent(eventBindingModel.getLinkEvent() == null || eventBindingModel.getLinkEvent().trim().isEmpty()
                ? eventBindingModel.getLinkImage()
                : eventBindingModel.getLinkEvent());

        eventRepository.save(eventEntity);
    }

    @Override
    public EventEntity getFirstEvent() {
        List<EventEntity> all = eventRepository.findAll();
        if (all.isEmpty()) {
            return null;
        }

        return all.get(0);
    }

    @Override
    public void deleteEvent() {
        eventRepository.deleteAll();
    }

    @Override
    public void cleanEvent() {
        EventEntity event = getFirstEvent();

        if (event == null) {
            return;
        }

        LocalDateTime eventAddedDateTIme = event.getDateTime();
        LocalDateTime now = LocalDateTime.now();

        long durationInMinutes = ChronoUnit.MINUTES.between(eventAddedDateTIme, now);

        if (durationInMinutes <= 1200) {
            deleteEvent();
        }
    }
}

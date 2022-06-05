package com.example.demo.schedule;

import com.example.demo.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CronScheduler {

    private final EventService eventService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CronScheduler.class);

    public CronScheduler(EventService eventService) {
        this.eventService = eventService;
    }

    @Scheduled(cron = "${schedulers.cron}")
    public void cleanEvents() {
        eventService.cleanEvent();
        LOGGER.info("HELLO, FROM CRON SCHEDULER AT {} I have cleaned up the events", LocalDateTime.now());
    }

}

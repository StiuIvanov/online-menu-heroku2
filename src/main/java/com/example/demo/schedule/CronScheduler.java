package com.example.demo.schedule;

import com.example.demo.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

    @Scheduled(cron = "${schedulers.cron2}")
    public void pingMyWebsite() throws IOException {

        HttpURLConnection connection = null;

        URL url = new URL("https://schroedinger.herokuapp.com/");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        System.out.println();
        LOGGER.info("PING https://schroedinger.herokuapp.com/ code " + responseCode + "at:{} ", LocalDateTime.now());
    }


}

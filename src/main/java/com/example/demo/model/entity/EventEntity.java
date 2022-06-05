package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class EventEntity extends BaseEntity {
    private String linkImage;
    private String linkEvent;
    private String embeddedLink;
    private LocalDateTime dateTime;

    public EventEntity() {
    }

    @Column(columnDefinition = "TEXT")
    public String getLinkImage() {
        return linkImage;
    }

    public EventEntity setLinkImage(String linkImage) {
        this.linkImage = linkImage;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getLinkEvent() {
        return linkEvent;
    }

    public EventEntity setLinkEvent(String linkEvent) {
        this.linkEvent = linkEvent;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getEmbeddedLink() {
        return embeddedLink;
    }

    public EventEntity setEmbeddedLink(String embeddedLink) {
        this.embeddedLink = embeddedLink;
        return this;
    }

    @Column
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public EventEntity setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}

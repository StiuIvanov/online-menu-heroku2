package com.example.demo.model.binding;

public class EventBindingModel {

    private String linkImage;
    private String linkEvent;
    private String embeddedLink;

    public EventBindingModel() {
    }

    public String getLinkImage() {
        return linkImage;
    }

    public EventBindingModel setLinkImage(String linkImage) {
        this.linkImage = linkImage;
        return this;
    }

    public String getLinkEvent() {
        return linkEvent;
    }

    public EventBindingModel setLinkEvent(String linkEvent) {
        this.linkEvent = linkEvent;
        return this;
    }

    public String getEmbeddedLink() {
        return embeddedLink;
    }

    public EventBindingModel setEmbeddedLink(String embeddedLink) {
        this.embeddedLink = embeddedLink;
        return this;
    }
}

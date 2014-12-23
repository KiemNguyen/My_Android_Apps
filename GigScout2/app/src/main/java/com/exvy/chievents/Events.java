package com.exvy.chievents;

/**
 * Created by Kiem on 12/21/14.
 */
public class Events {

    private String title;
    private String link;
    private String imageLink;

    public Events(String title, String link, String imageLink) {
        this.title = title;
        this.link = link;
        this.imageLink = imageLink;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getImageLink() {
        return imageLink;
    }
}

package com.example.rathana.recyclerviewdemo.model;

public class Film {
    private int id;
    private  String title;
    private String description;
    private String view;
    private int thumb;
    private String channel;

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Film(String title, String view, int thumb, String channel) {
        this.title = title;
        this.view = view;
        this.thumb = thumb;
        this.channel = channel;
    }

    public Film(){}
    public Film(int id, String title, String description, String view) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.view = view;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}

package com.example.demo.classes;

public class Writes {
    private String UID;
    private String id;
    private String time;
    private String headline;
    private String content;

    public Writes() {
    }

    public Writes(String UID, String id, String time, String headline, String content) {
        this.UID = UID;
        this.id = id;
        this.time = time;
        this.headline = headline;
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                "UID='" + UID + '\'' +
                ", id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", headline='" + headline + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

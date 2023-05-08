package com.example.demo.classes;

public class Ju {
    private String id;
    private String content;
    private String poetID;
    private String poetName;
    private String poetryID;
    private String poetryName;

    public Ju() {}

    public Ju(String id, String content, String poetID, String poetName, String poetryID, String poetryName) {
        this.id = id;
        this.content = content;
        this.poetID = poetID;
        this.poetName = poetName;
        this.poetryID = poetryID;
        this.poetryName = poetryName;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", poetID='" + poetID + '\'' +
                ", poetName='" + poetName + '\'' +
                ", poetryID='" + poetryID + '\'' +
                ", poetryName='" + poetryName + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPoetID(String poetID) {
        this.poetID = poetID;
    }

    public void setPoetName(String poetName) {
        this.poetName = poetName;
    }

    public void setPoetryID(String poetryID) {
        this.poetryID = poetryID;
    }

    public void setPoetryName(String poetryName) {
        this.poetryName = poetryName;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getPoetID() {
        return poetID;
    }

    public String getPoetName() {
        return poetName;
    }

    public String getPoetryID() {
        return poetryID;
    }

    public String getPoetryName() {
        return poetryName;
    }
}

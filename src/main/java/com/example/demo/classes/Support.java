package com.example.demo.classes;

public class Support {
    private String UID;
    private String id;

    public Support() {
    }

    public Support(String UID, String id) {
        this.UID = UID;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "UID='" + UID + '\'' +
                ", id='" + id + '\'' +
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
}

package com.example.demo.classes;

public class MyUser {
    private String uid;
    private String username;
    private String password;
    private String email;
    private String image;

    public MyUser() {
    }

    public MyUser(String uid, String username, String password, String email, String image) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.image = image;
    }

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

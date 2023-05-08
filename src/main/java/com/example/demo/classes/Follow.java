package com.example.demo.classes;

public class Follow {
    private String following;
    private String followed;
    private String followedname;

    public Follow(String following, String followed, String followedname) {
        this.following = following;
        this.followed = followed;
        this.followedname = followedname;
    }

    @Override
    public String toString() {
        return "{" +
                "following='" + following + '\'' +
                ", followed='" + followed + '\'' +
                ", followedname='" + followedname + '\'' +
                '}';
    }

    public Follow() {
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowed() {
        return followed;
    }

    public void setFollowed(String followed) {
        this.followed = followed;
    }

    public String getFollowedname() {
        return followedname;
    }

    public void setFollowedname(String followedname) {
        this.followedname = followedname;
    }
}

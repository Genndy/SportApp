package com.genndy.sportapp.menu.models;

public class Game {
    private String _id;
    private String name;
    private String photoURL;

    public Game(String _id, String name, String photoURL) {
        this._id = _id;
        this.name = name;
        this.photoURL = photoURL;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}

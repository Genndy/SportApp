package com.genndy.sportapp.content.gallery.models;

public class Photo {
    private String _id;
    private String photoURL;

    public String getGameName() {
        return gameName;
    }

    private String gameName;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Photo(String _id, String photoURL, String gameName) {
        this._id = _id;
        this.photoURL = photoURL;
        this.gameName = gameName;
    }
}

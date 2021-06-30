package com.genndy.sportapp.content.players.model;

public class Player {
    private String _id;
    private String name;
    private String photoURL;
    private String game;

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

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Player(String _id, String name, String photoURL, String game) {
        this._id = _id;
        this.name = name;
        this.photoURL = photoURL;
        this.game = game;
    }
}

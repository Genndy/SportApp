package com.genndy.sportapp.content.rules.models;

public class Rules {
    private String _id;
    private String name;
    private String text;

    public Rules(String _id, String name, String text) {
        this._id = _id;
        this.name = name;
        this.text = text;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

}
